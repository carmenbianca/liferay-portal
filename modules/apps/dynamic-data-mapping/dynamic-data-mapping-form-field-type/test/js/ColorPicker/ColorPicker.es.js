/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fireEvent} from '@testing-library/react';

import ColorPicker from '../../../src/main/resources/META-INF/resources/ColorPicker/ColorPicker.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const name = 'colorPicker';
const spritemap = 'icons.svg';

const ColorPickerWithContextMock = withContextMock(ColorPicker);

describe('Field Color Picker', () => {
	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('renders field disabled', () => {
		component = new ColorPickerWithContextMock({
			name,
			readOnly: false,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders field with helptext', () => {
		component = new ColorPickerWithContextMock({
			name,
			spritemap,
			tip: 'Helptext',
		});

		expect(component).toMatchSnapshot();
	});

	it('renders field with label', () => {
		component = new ColorPickerWithContextMock({
			label: 'Label',
			name,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders with basic color', () => {
		const color = '#FF67AA';

		component = new ColorPickerWithContextMock({
			name,
			readOnly: true,
			spritemap,
			value: color,
		});

		expect(component.element.querySelector('input').value).toBe(color);
	});

	it.skip('emits field edit event on field change', done => {
		const handleFieldEdited = () => {
			const inputEl = component.element.querySelector('input');
			expect(inputEl.value).toBe('ffffff');
			done();
		};

		const events = {fieldEdited: handleFieldEdited};

		component = new ColorPickerWithContextMock({
			events,
			name,
			spritemap,
		});

		const inputEl = component.element.querySelector('input');

		fireEvent.input(inputEl, {target: {value: 'ffffff'}});
	});
});
