/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import Paragraph from '../../../src/main/resources/META-INF/resources/Paragraph/Paragraph.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const spritemap = 'icons.svg';

const defaultParagraphConfig = {
	name: 'textField',
	spritemap,
};

const ParagraphWithContextMock = withContextMock(Paragraph);

describe('Field Paragraph', () => {
	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('is readOnly', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			readOnly: true,
		});

		expect(component).toMatchSnapshot();
	});

	it('has an id', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			id: 'ID',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a label', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			label: 'label',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a placeholder', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			placeholder: 'Placeholder',
		});

		expect(component).toMatchSnapshot();
	});

	it('is not required', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			required: false,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders Label if showLabel is true', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			label: 'text',
			showLabel: true,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a spritemap', () => {
		component = new ParagraphWithContextMock(defaultParagraphConfig);

		expect(component).toMatchSnapshot();
	});

	it('has a value', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			value: 'value',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a key', () => {
		component = new ParagraphWithContextMock({
			...defaultParagraphConfig,
			key: 'key',
		});

		expect(component).toMatchSnapshot();
	});
});
