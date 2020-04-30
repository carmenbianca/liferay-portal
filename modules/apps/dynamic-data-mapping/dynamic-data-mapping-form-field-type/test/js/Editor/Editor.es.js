/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import Editor from '../../../src/main/resources/META-INF/resources/Editor/Editor.es';
import withContextMock from '../__mocks__/withContextMock.es';

let component;
const spritemap = 'icons.svg';

const defaultEditorConfig = {
	name: 'textField',
	spritemap,
};

const EditorWithContextMock = withContextMock(Editor);

describe('Field Editor', () => {
	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('is readOnly', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			readOnly: true,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a helptext', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			tip: 'Type something',
		});

		expect(component).toMatchSnapshot();
	});

	it('has an id', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			id: 'ID',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a label', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			label: 'label',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a placeholder', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			placeholder: 'Placeholder',
		});

		expect(component).toMatchSnapshot();
	});

	it('is not required', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			required: false,
		});

		expect(component).toMatchSnapshot();
	});

	it('renders Label if showLabel is true', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			label: 'text',
			showLabel: true,
		});

		expect(component).toMatchSnapshot();
	});

	it('has a spritemap', () => {
		component = new EditorWithContextMock(defaultEditorConfig);

		expect(component).toMatchSnapshot();
	});

	it('has a value', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			value: 'value',
		});

		expect(component).toMatchSnapshot();
	});

	it('has a key', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
			key: 'key',
		});

		expect(component).toMatchSnapshot();
	});

	it('emits a change value when onChangeEditor method is triggered', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
		});
		const event = {};
		const spy = jest.spyOn(component, 'emit');

		component._onChangeEditor(event);

		expect(spy).toBeCalled();
	});

	it('triggers AlloyEditor actionPerformed method', () => {
		component = new EditorWithContextMock({
			...defaultEditorConfig,
		});

		component._onActionPerformed({
			data: {
				props: {},
			},
		});

		component.willReceiveState({
			children: true,
			value: {
				newVal: '<p>test</p>',
			},
		});

		expect(component).toMatchSnapshot();
	});
});
