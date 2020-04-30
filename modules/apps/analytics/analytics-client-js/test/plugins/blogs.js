/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import fetchMock from 'fetch-mock';
import dom from 'metal-dom';

import AnalyticsClient from '../../src/analytics';

const applicationId = 'Blog';

const googleUrl = 'http://google.com/';

const createBlogElement = () => {
	const blogElement = document.createElement('div');

	blogElement.dataset.analyticsAssetId = 'assetId';
	blogElement.dataset.analyticsAssetTitle = 'Blog Title 1';
	blogElement.dataset.analyticsAssetType = 'blog';
	blogElement.innerText =
		'Lorem ipsum dolor, sit amet consectetur adipisicing elit.';

	document.body.appendChild(blogElement);

	return blogElement;
};

describe('Blogs Plugin', () => {
	let Analytics;

	beforeEach(() => {
		// Force attaching DOM Content Loaded event
		Object.defineProperty(document, 'readyState', {
			value: 'loading',
			writable: false,
		});

		fetchMock.mock('*', () => 200);

		Analytics = AnalyticsClient.create();
	});

	afterEach(() => {
		Analytics.reset();
		Analytics.dispose();

		fetchMock.restore();
	});

	describe('blogViewed event', () => {
		it('is fired for every blog on the page', () => {
			const blogElement = createBlogElement();

			const domContentLoaded = new Event('DOMContentLoaded');

			document.dispatchEvent(domContentLoaded);

			const events = Analytics.getEvents().filter(
				({eventId}) => eventId === 'blogViewed'
			);

			expect(events.length).toBeGreaterThanOrEqual(1);

			expect(events[0]).toEqual(
				expect.objectContaining({
					applicationId,
					eventId: 'blogViewed',
					properties: expect.objectContaining({
						entryId: 'assetId',
					}),
				})
			);

			document.body.removeChild(blogElement);
		});
	});

	describe('blogClicked event', () => {
		it('is fired when clicking an image inside a blog', () => {
			const blogElement = createBlogElement();

			const imageInsideBlog = document.createElement('img');

			imageInsideBlog.src = googleUrl;

			blogElement.appendChild(imageInsideBlog);

			dom.triggerEvent(imageInsideBlog, 'click');

			expect(Analytics.getEvents()).toEqual([
				expect.objectContaining({
					applicationId,
					eventId: 'blogClicked',
					properties: expect.objectContaining({
						entryId: 'assetId',
						src: googleUrl,
						tagName: 'img',
					}),
				}),
			]);

			document.body.removeChild(blogElement);
		});

		it('is fired when clicking a link inside a blog', () => {
			const blogElement = createBlogElement();

			const text = 'Link inside a Blog';

			const linkInsideBlog = document.createElement('a');

			linkInsideBlog.href = googleUrl;

			setInnerHTML(linkInsideBlog, text);

			blogElement.appendChild(linkInsideBlog);

			dom.triggerEvent(linkInsideBlog, 'click');

			expect(Analytics.getEvents()).toEqual([
				expect.objectContaining({
					applicationId,
					eventId: 'blogClicked',
					properties: expect.objectContaining({
						entryId: 'assetId',
						href: googleUrl,
						tagName: 'a',
						text,
					}),
				}),
			]);

			document.body.removeChild(blogElement);
		});

		it('is fired when clicking any other element inside a blog', () => {
			const blogElement = createBlogElement();

			const paragraphInsideBlog = document.createElement('p');

			paragraphInsideBlog.href = googleUrl;

			setInnerHTML(paragraphInsideBlog, 'Paragraph inside a Blog');

			blogElement.appendChild(paragraphInsideBlog);

			dom.triggerEvent(paragraphInsideBlog, 'click');

			expect(Analytics.getEvents()).toEqual([
				expect.objectContaining({
					applicationId,
					eventId: 'blogClicked',
					properties: expect.objectContaining({
						entryId: 'assetId',
						tagName: 'p',
					}),
				}),
			]);

			document.body.removeChild(blogElement);
		});
	});
});
