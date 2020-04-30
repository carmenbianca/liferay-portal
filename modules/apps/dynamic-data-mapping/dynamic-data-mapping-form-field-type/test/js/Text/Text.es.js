/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fireEvent} from '@testing-library/react';

import Text from '../../../src/main/resources/META-INF/resources/Text/Text.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const spritemap = 'icons.svg';

const defaultTextConfig = {
	name: 'textField',
	spritemap,
};

const TextWithContextMock = withContextMock(Text);

describe('Field Text', () => {
	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('is not readOnly', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			readOnly: false,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a helptext', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			tip: 'Type something',
		});

		expect(component).toMatchSnapshot();
	});

	it('has an id', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			id: 'ID',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a label', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			label: 'label',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a placeholder', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			placeholder: 'Placeholder',
		});

		expect(component).toMatchSnapshot();
	});

	it('is not required', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			required: false,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders Label if showLabel is true', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			label: 'text',
			showLabel: true,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a spritemap', () => {
		component = new TextWithContextMock(defaultTextConfig);

		expect(component).toMatchSnapshot();
	});

	it('has a value', () => {
		component = new TextWithContextMock({
			...defaultTextConfig,
			value: 'value',
		});

		expect(component).toMatchSnapshot();
	});

	it('emits a field edit with correct parameters', done => {
		const handleFieldEdited = data => {
			expect(data).toEqual(
				expect.objectContaining({
					fieldInstance: expect.any(Object),
					originalEvent: expect.any(Object),
					value: expect.any(String),
				})
			);
			done();
		};

		const events = {fieldEdited: handleFieldEdited};

		component = new TextWithContextMock({
			...defaultTextConfig,
			events,
			key: 'input',
		});

		const input = component.element.querySelector('input');

		fireEvent.change(input, {
			target: {
				value: 'test',
			},
		});
	});
});
