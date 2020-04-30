/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import './KeyValueRegister.soy';

import {normalizeFieldName} from 'dynamic-data-mapping-form-renderer';
import React, {useRef} from 'react';

import {FieldBaseProxy} from '../FieldBase/ReactFieldBase.es';
import {TextWithFieldBase, useSyncValue} from '../Text/Text.es';
import getConnectedReactComponentAdapter from '../util/ReactComponentAdapter.es';
import {connectStore} from '../util/connectStore.es';
import templates from './KeyValueAdapter.soy';

const KeyValue = ({disabled, onChange, value, ...otherProps}) => (
	<div className="active form-text key-value-editor">
		<label className="control-label key-value-label">
			{Liferay.Language.get('field-name')}:
		</label>

		<input
			{...otherProps}
			className="key-value-input"
			onChange={event => {
				const value = normalizeFieldName(event.target.value);
				onChange({target: {value}});
			}}
			readOnly={disabled}
			type="text"
			value={value}
		/>
	</div>
);

const KeyValueWithFieldBase = ({
	dispatch,
	generateKeyword: initialGenerateKeyword = true,
	keyword,
	keywordReadOnly,
	name,
	onKeywordBlur,
	onKeywordChange,
	onTextBlur,
	onTextChange,
	onTextFocus,
	placeholder,
	readOnly,
	required,
	showLabel,
	spritemap,
	store,
	value,
	visible,
	...otherProps
}) => {
	const generateKeywordRef = useRef(initialGenerateKeyword);

	return (
		<FieldBaseProxy
			{...otherProps}
			dispatch={dispatch}
			name={name}
			readOnly={readOnly}
			required={required}
			showLabel={showLabel}
			spritemap={spritemap}
			store={store}
			visible={visible}
		>
			<TextWithFieldBase
				dispatch={dispatch}
				name={`keyValueLabel${name}`}
				onBlur={onTextBlur}
				onChange={event => {
					const {value} = event.target;

					if (generateKeywordRef.current) {
						const newKeyword = normalizeFieldName(value);
						onKeywordChange(event, newKeyword);
					}

					onTextChange(event);
				}}
				onFocus={onTextFocus}
				placeholder={placeholder}
				readOnly={readOnly}
				required={required}
				showLabel={showLabel}
				spritemap={spritemap}
				store={store}
				value={value}
				visible={visible}
			/>
			<KeyValue
				disabled={keywordReadOnly}
				onBlur={onKeywordBlur}
				onChange={event => {
					const {value} = event.target;

					generateKeywordRef.current = false;
					onKeywordChange(event, value);
				}}
				value={keyword}
			/>
		</FieldBaseProxy>
	);
};

const KeyValueProxy = connectStore(
	({emit, keyword: initialKeyword, ...otherProps}) => {
		const [keyword, setKeyword] = useSyncValue(initialKeyword);

		return (
			<KeyValueWithFieldBase
				{...otherProps}
				keyword={keyword}
				onKeywordBlur={event =>
					emit('fieldKeywordBlurred', event, event.target.value)
				}
				onKeywordChange={(event, value) => {
					setKeyword(value);
					emit('fieldKeywordEdited', event, value);
				}}
				onTextBlur={event =>
					emit('fieldBlurred', event, event.target.value)
				}
				onTextChange={event =>
					emit('fieldEdited', event, event.target.value)
				}
				onTextFocus={event =>
					emit('fieldFocused', event, event.target.value)
				}
			/>
		);
	}
);

const ReactKeyValueAdapter = getConnectedReactComponentAdapter(
	KeyValueProxy,
	templates
);

export {ReactKeyValueAdapter, KeyValueWithFieldBase};
export default ReactKeyValueAdapter;
