/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayInput} from '@clayui/form';
import {Editor} from 'frontend-editor-ckeditor-web';
import React, {useEffect, useRef, useState} from 'react';

import getConnectedReactComponentAdapter from '../util/ReactComponentAdapterWithObserver.es';
import templates from './RichTextAdapter.soy';

const CKEDITOR_CONFIG = {
	toolbar: [
		{items: ['Undo', 'Redo'], name: 'clipboard'},
		'/',
		{
			items: [
				'Bold',
				'Italic',
				'Underline',
				'Strike',
				'-',
				'CopyFormatting',
				'RemoveFormat',
			],
			name: 'basicstyles',
		},
		{
			items: [
				'NumberedList',
				'BulletedList',
				'-',
				'Outdent',
				'Indent',
				'-',
				'Blockquote',
				'-',
				'JustifyLeft',
				'JustifyCenter',
				'JustifyRight',
				'JustifyBlock',
			],
			name: 'paragraph',
		},
		{items: ['Link', 'Unlink', 'Anchor'], name: 'links'},
		{
			items: ['Image', 'Table', 'HorizontalRule', 'SpecialChar'],
			name: 'insert',
		},
		'/',
		{items: ['Styles', 'Format', 'Font', 'FontSize'], name: 'styles'},
		{items: ['TextColor', 'BGColor'], name: 'colors'},
		{items: ['Maximize'], name: 'tools'},
		{
			items: ['Source'],
			name: 'document',
		},
	],
};

/**
 * Use Sync Value to synchronize the initial value with the current internal
 * value, only update the internal value with the new initial value if the
 * values are different and when the value is not changed for more than ms.
 */
const useSyncValue = newValue => {
	// Maintains the reference of the last value to check in later renderings if the
	// value is new or keeps the same, it covers cases where the value typed by
	// the user is sent to LayoutProvider but it does not descend with the new changes.
	const previousValueRef = useRef(newValue);

	const [value, setValue] = useState(newValue);

	useEffect(() => {
		const handler = setTimeout(() => {
			if (value !== newValue && previousValueRef.current !== newValue) {
				previousValueRef.current = newValue;
				setValue(newValue);
			}
		}, 300);

		return () => {
			clearTimeout(handler);
		};
	}, [newValue, value]);

	return [value, setValue];
};

const RichText = ({data, dispatch, name, readOnly}) => {
	const [value, setValue] = useSyncValue(data);

	const editorProps = {
		config: CKEDITOR_CONFIG,
		data: value,
	};

	if (readOnly) {
		editorProps.readOnly = true;
		editorProps.style = {pointerEvents: 'none'};
	}
	else {
		editorProps.onChange = event => {
			setValue(event.editor.getData());

			dispatch({
				payload: event.editor.getData(),
				type: 'value',
			});
		};
	}

	const style = {
		border: '1px solid #E7E7ED',
		height: '148px',
	};

	return (
		<>
			{readOnly && data && (
				<div
					dangerouslySetInnerHTML={{
						__html: data,
					}}
					name={`html_text_${name}`}
					style={style}
				></div>
			)}

			{readOnly && !data && (
				<div
					name={`html_text_${name}`}
					style={{...style, color: '#A7A9BC', padding: '16px'}}
				>
					{Liferay.Language.get('click-to-add-a-rich-text')}
				</div>
			)}

			{!readOnly && <Editor {...editorProps} />}

			<ClayInput name={name} type="hidden" value={data} />
		</>
	);
};

const ReactRichTextAdapter = getConnectedReactComponentAdapter(
	RichText,
	templates
);

export {ReactRichTextAdapter};
export default ReactRichTextAdapter;
