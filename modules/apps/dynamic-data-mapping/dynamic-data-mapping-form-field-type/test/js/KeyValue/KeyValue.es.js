/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import KeyValue from '../../../src/main/resources/META-INF/resources/KeyValue/KeyValue.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const spritemap = 'icons.svg';

const KeyValueWithContextMock = withContextMock(KeyValue);

describe('KeyValue', () => {
	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('is not edidable', () => {
		component = new KeyValueWithContextMock({
			name: 'keyValue',
			readOnly: false,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a helptext', () => {
		component = new KeyValueWithContextMock({
			name: 'keyValue',
			spritemap,
			tip: 'Type something',
		});

		expect(component).toMatchSnapshot();
	});

	it('has an id', () => {
		component = new KeyValueWithContextMock({
			id: 'ID',
			name: 'keyValue',
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a label', () => {
		component = new KeyValueWithContextMock({
			label: 'label',
			name: 'keyValue',
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a predefined Value', () => {
		component = new KeyValueWithContextMock({
			name: 'keyValue',
			placeholder: 'Option 1',
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('is not required', () => {
		component = new KeyValueWithContextMock({
			name: 'keyValue',
			required: false,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders Label if showLabel is true', () => {
		component = new KeyValueWithContextMock({
			label: 'text',
			name: 'keyValue',
			showLabel: true,
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a spritemap', () => {
		component = new KeyValueWithContextMock({
			name: 'keyValue',
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a value', () => {
		component = new KeyValueWithContextMock({
			name: 'keyValue',
			spritemap,
			value: 'value',
		});

		expect(component).toMatchSnapshot();
	});

	it('renders component with a key', () => {
		component = new KeyValueWithContextMock({
			keyword: 'key',
			name: 'keyValue',
			spritemap,
		});

		expect(component).toMatchSnapshot();
	});
});
