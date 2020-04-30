/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fireEvent} from '@testing-library/react';

import Options from '../../../src/main/resources/META-INF/resources/Options/Options.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const spritemap = 'icons.svg';

const OptionsWithContextMock = withContextMock(Options);

const optionsValue = {
	en_US: [
		{
			label: 'Option 1',
			value: 'Option1',
		},
		{
			label: 'Option 2',
			value: 'Option2',
		},
	],
};

describe('Options', () => {
	beforeEach(() => jest.useFakeTimers());

	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('shows the options', () => {
		component = new OptionsWithContextMock({
			name: 'options',
			spritemap,
			value: optionsValue,
		});

		expect(component).toMatchSnapshot();
	});

	it('shows an empty option when value is an array of size 1', () => {
		component = new OptionsWithContextMock({
			name: 'options',
			spritemap,
			value: {
				[themeDisplay.getLanguageId()]: [
					{
						label: 'Option',
						value: 'Option',
					},
				],
			},
		});

		jest.runAllTimers();

		expect(component.defaultOption).toEqual(true);

		const {element} = component;
		const labelInputs = element.querySelectorAll('.ddm-field-text');

		expect(labelInputs.length).toEqual(2);
		expect(labelInputs[0].value).toEqual('Option');
		expect(labelInputs[1].value).toEqual('');

		const valueInputs = element.querySelectorAll('.key-value-input');

		expect(valueInputs.length).toEqual(2);
		expect(valueInputs[0].value).toEqual('Option');
		expect(valueInputs[1].value).toEqual('');
	});

	it('does not show an empty option when translating', () => {
		component = new OptionsWithContextMock({
			defaultLanguageId: themeDisplay.getLanguageId(),
			editingLanguageId: 'pt_BR',
			name: 'options',
			spritemap,
			value: {
				[themeDisplay.getLanguageId()]: [
					{
						label: 'Option',
						value: 'Option',
					},
				],
			},
		});

		jest.runAllTimers();

		expect(component.defaultOption).toEqual(true);

		const {element} = component;
		const labelInputs = element.querySelectorAll('.ddm-field-text');

		expect(labelInputs.length).toEqual(1);
	});

	it('edits the value of an option based on the label', () => {
		component = new OptionsWithContextMock({
			name: 'options',
			spritemap,
			value: {
				[themeDisplay.getLanguageId()]: [
					{
						label: 'Option',
						value: 'Option',
					},
				],
			},
		});

		jest.runAllTimers();

		const {element} = component;
		const labelInputs = element.querySelectorAll('.ddm-field-text');

		fireEvent.change(labelInputs[0], {
			target: {
				value: 'Hello',
			},
		});

		jest.runAllTimers();

		const valueInputs = element.querySelectorAll('.key-value-input');

		expect(valueInputs[0].value).toEqual('Hello');
	});

	it('inserts a new empty option when editing the last option', () => {
		component = new OptionsWithContextMock({
			name: 'options',
			spritemap,
			value: {
				[themeDisplay.getLanguageId()]: [
					{
						label: 'Option',
						value: 'Option',
					},
				],
			},
		});

		jest.runAllTimers();

		const {element} = component;
		const labelInputs = element.querySelectorAll('.ddm-field-text');

		fireEvent.change(labelInputs[1], {
			target: {
				value: 'Hello',
			},
		});

		jest.runAllTimers();

		const valueInputs = element.querySelectorAll('.key-value-input');

		expect(valueInputs.length).toEqual(labelInputs.length + 1);
	});

	it('does not insert a new empty option automatically if translating', () => {
		component = new OptionsWithContextMock({
			defaultLanguageId: themeDisplay.getLanguageId(),
			editingLanguageId: 'pt_BR',
			name: 'options',
			spritemap,
			value: {
				[themeDisplay.getLanguageId()]: [
					{
						label: 'Option',
						value: 'Option',
					},
				],
			},
		});

		jest.runAllTimers();

		const {element} = component;
		const labelInputs = element.querySelectorAll('.ddm-field-text');

		fireEvent.input(labelInputs[0], {target: {value: 'Hello'}});

		jest.runAllTimers();

		const valueInputs = element.querySelectorAll('.key-value-input');

		expect(valueInputs.length).toEqual(labelInputs.length);
	});
});
