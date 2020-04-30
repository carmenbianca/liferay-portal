/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fireEvent} from '@testing-library/react';

import Grid from '../../../src/main/resources/META-INF/resources/Grid/Grid.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const spritemap = 'icons.svg';

const GridWithContextMock = withContextMock(Grid);

describe('Grid', () => {
	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('renders columns', () => {
		component = new Grid({
			columns: [
				{
					label: 'col1',
					value: 'fieldId',
				},
				{
					label: 'col2',
					value: 'fieldId',
				},
			],
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders no columns when columns comes empty', () => {
		component = new Grid({
			columns: [],
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('is not edidable', () => {
		component = new Grid({
			readOnly: false,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a tip', () => {
		component = new Grid({
			spritemap,
			tip: 'Type something',
		});

		expect(component).toMatchSnapshot();
	});

	it('has an id', () => {
		component = new Grid({
			id: 'ID',
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a label', () => {
		component = new Grid({
			label: 'label',
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('is not required', () => {
		component = new Grid({
			required: false,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders rows', () => {
		component = new Grid({
			rows: [
				{
					label: 'row1',
					value: 'fieldId',
				},
				{
					label: 'row2',
					value: 'fieldId',
				},
			],
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders no rows when row comes empty', () => {
		component = new Grid({
			rows: [],
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders Label if showLabel is true', () => {
		component = new Grid({
			label: 'text',
			showLabel: true,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('emits a fieldBlurred event when blurring the radio input', done => {
		const handleFieldBlurred = data => {
			expect(data).toEqual(
				expect.objectContaining({
					value: 'colFieldId1',
				})
			);
			done();
		};

		const events = {fieldBlurred: handleFieldBlurred};

		component = new GridWithContextMock({
			columns: [
				{
					label: 'col1',
					value: 'colFieldId1',
				},
				{
					label: 'col2',
					value: 'colFieldId2',
				},
			],
			events,
			readOnly: false,
			rows: [
				{
					label: 'row1',
					value: 'rowFieldId1',
				},
				{
					label: 'row2',
					value: 'rowFieldId2',
				},
			],
			spritemap,
		});

		const radioInputElement = component.element.querySelector(
			'input[value][type="radio"][name="rowFieldId1"]:not([value="colFieldId2"])'
		);

		fireEvent.blur(radioInputElement);
	});

	// This test needs to be investigated further, it is failing at metal-events because it
	// has no events adding, strange that we are adding but only this one is failing.
	// This is not reproducible in manual tests.
	it.skip('emits a fieldEdited event when changing the state of radio input', done => {
		const handleFieldEdited = data => {
			expect(data).toEqual(
				expect.objectContaining({
					fieldInstance: expect.any(Object),
					originalEvent: expect.any(Object),
					value: {
						rowFieldId1: 'colFieldId1',
					},
				})
			);
			done();
		};

		const events = {fieldEdited: handleFieldEdited};

		component = new GridWithContextMock({
			columns: [
				{
					label: 'col1',
					value: 'colFieldId1',
				},
				{
					label: 'col2',
					value: 'colFieldId2',
				},
			],
			events,
			readOnly: false,
			rows: [
				{
					label: 'row1',
					value: 'rowFieldId1',
				},
				{
					label: 'row2',
					value: 'rowFieldId2',
				},
			],
			spritemap,
		});

		const radioInputElement = component.element.querySelector(
			'input[value][type="radio"][name="rowFieldId1"]:not([value="colFieldId2"])'
		);

		fireEvent.click(radioInputElement);
	});

	it('emits a fieldFocused event when focusing a radio input', done => {
		const handleFieldFocused = data => {
			expect(data).toEqual(
				expect.objectContaining({
					fieldInstance: expect.any(Object),
					originalEvent: expect.any(Object),
					value: 'colFieldId1',
				})
			);
			done();
		};

		const events = {fieldFocused: handleFieldFocused};

		component = new GridWithContextMock({
			columns: [
				{
					label: 'col1',
					value: 'colFieldId1',
				},
				{
					label: 'col2',
					value: 'colFieldId2',
				},
			],
			events,
			readOnly: false,
			rows: [
				{
					label: 'row1',
					value: 'rowFieldId1',
				},
				{
					label: 'row2',
					value: 'rowFieldId2',
				},
			],
			spritemap,
		});

		const radioInputElement = component.element.querySelector(
			'input[value][type="radio"][name="rowFieldId1"]:not([value="colFieldId2"])'
		);

		fireEvent.focus(radioInputElement);
	});
});
