/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import DocumentLibrary from '../../../src/main/resources/META-INF/resources/DocumentLibrary/DocumentLibrary.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const spritemap = 'icons.svg';

const defaultDocumentLibraryConfig = {
	name: 'textField',
	spritemap,
};

const DocumentLibraryWithContextMock = withContextMock(DocumentLibrary);

describe('Field DocumentLibrary', () => {
	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('is not readOnly', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			readOnly: false,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a helptext', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			tip: 'Type something',
		});

		expect(component).toMatchSnapshot();
	});

	it('has an id', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			id: 'ID',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a label', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			label: 'label',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a placeholder', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			placeholder: 'Placeholder',
		});

		expect(component).toMatchSnapshot();
	});

	it('is not required', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			required: false,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders Label if showLabel is true', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			label: 'text',
			showLabel: true,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a spritemap', () => {
		component = new DocumentLibraryWithContextMock(
			defaultDocumentLibraryConfig
		);

		expect(component).toMatchSnapshot();
	});

	it('has a value', () => {
		component = new DocumentLibraryWithContextMock({
			...defaultDocumentLibraryConfig,
			value: '{"id":"123"}',
		});

		expect(component).toMatchSnapshot();
	});
});
