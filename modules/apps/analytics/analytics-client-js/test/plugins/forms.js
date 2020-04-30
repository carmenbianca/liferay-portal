/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import fetchMock from 'fetch-mock';

import AnalyticsClient from '../../src/analytics';

const applicationId = 'Form';

describe('Forms Plugin', () => {
	let Analytics;
	let duration;

	beforeEach(() => {
		// Force attaching DOM Content Loaded event
		Object.defineProperty(document, 'readyState', {
			value: 'loading',
			writable: false,
		});

		if (!global.performance.clearMarks) {
			global.performance.clearMarks = () => {};
		}

		if (!global.performance.mark) {
			global.performance.mark = () => {};
		}

		if (!global.performance.measure) {
			global.performance.measure = () => {};
		}

		if (!global.performance.getEntriesByName) {
			global.performance.getEntriesByName = () => [
				{
					duration: duration || 1,
				},
			];
		}

		fetchMock.mock('*', () => 200);

		Analytics = AnalyticsClient.create();
	});

	afterEach(() => {
		Analytics.reset();
		Analytics.dispose();

		fetchMock.restore();
	});

	describe('formViewed event', () => {
		it('is fired for every form on the page', () => {
			const formWithAssetId = document.createElement('form');

			formWithAssetId.dataset.analyticsAssetId = 'assetId';
			formWithAssetId.dataset.analyticsAssetTitle = 'Form Title 1';

			document.body.appendChild(formWithAssetId);

			const formWithFormId = document.createElement('form');

			formWithFormId.dataset.analyticsFormId = 'formId';
			formWithFormId.dataset.analyticsAssetTitle = 'Form Title 2';

			document.body.appendChild(formWithFormId);

			const domContentLoaded = new Event('DOMContentLoaded');

			document.dispatchEvent(domContentLoaded);

			const events = Analytics.getEvents().filter(
				({eventId}) => eventId === 'formViewed'
			);

			expect(events).toEqual([
				expect.objectContaining({
					applicationId,
					eventId: 'formViewed',
					properties: expect.objectContaining({
						formId: 'assetId',
					}),
				}),
				expect.objectContaining({
					applicationId,
					eventId: 'formViewed',
					properties: expect.objectContaining({
						formId: 'formId',
					}),
				}),
			]);

			document.body.removeChild(formWithAssetId);
			document.body.removeChild(formWithFormId);
		});
	});

	describe('formSubmitted event', () => {
		it('is fired when a form is submitted', () => {
			const form = document.createElement('form');

			form.dataset.analyticsAssetId = 'formId';
			form.dataset.analyticsAssetTitle = 'Form Title';

			document.body.appendChild(form);

			form.addEventListener('submit', event => event.preventDefault());

			const event = new Event('submit', {
				cancelable: true,
			});

			form.dispatchEvent(event);

			const events = Analytics.getEvents().filter(
				({eventId}) => eventId === 'formSubmitted'
			);

			expect(events).toEqual([
				expect.objectContaining({
					applicationId,
					eventId: 'formSubmitted',
					properties: {
						formId: 'formId',
						title: 'Form Title',
					},
				}),
			]);
		});
	});

	describe('fieldFocused event', () => {
		it('is fired whenever a field is focused', () => {
			const form = document.createElement('form');

			form.dataset.analyticsAssetId = 'formId';
			form.dataset.analyticsAssetTitle = 'Form Title';

			document.body.appendChild(form);

			const field = document.createElement('input');

			field.name = 'myField';
			field.type = 'text';

			form.appendChild(field);

			field.dispatchEvent(new Event('focus'));

			const events = Analytics.getEvents().filter(
				({eventId}) => eventId === 'fieldFocused'
			);

			expect(events).toEqual([
				expect.objectContaining({
					applicationId,
					eventId: 'fieldFocused',
					properties: {
						fieldName: 'myField',
						formId: 'formId',
					},
				}),
			]);
		});
	});

	describe('fieldBlurred event', () => {
		it('is fired whenever a field is blurred', () => {
			const form = document.createElement('form');

			form.dataset.analyticsAssetId = 'formId';
			form.dataset.analyticsAssetTitle = 'Form Title';

			document.body.appendChild(form);

			const field = document.createElement('input');

			field.name = 'myField';
			field.type = 'text';

			form.appendChild(field);

			field.dispatchEvent(new Event('focus'));

			// Fake timing.
			duration = 1500;

			field.dispatchEvent(new Event('blur'));

			const events = Analytics.getEvents().filter(
				({eventId}) => eventId === 'fieldBlurred'
			);

			expect(events).toEqual([
				expect.objectContaining({
					applicationId,
					eventId: 'fieldBlurred',
					properties: expect.objectContaining({
						fieldName: 'myField',
						focusDuration: expect.any(Number),
						formId: 'formId',
					}),
				}),
			]);

			expect(events[0].properties.focusDuration).toBeGreaterThanOrEqual(
				1500
			);
		});
	});
});
