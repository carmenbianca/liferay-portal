/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import './RadioRegister.soy';

import {ClayRadio} from '@clayui/form';
import React, {useMemo} from 'react';

import {FieldBaseProxy} from '../FieldBase/ReactFieldBase.es';
import getConnectedReactComponentAdapter from '../util/ReactComponentAdapter.es';
import {connectStore} from '../util/connectStore.es';
import {setJSONArrayValue} from '../util/setters.es';
import templates from './RadioAdapter.soy';

const Radio = ({
	disabled,
	inline,
	name,
	onBlur,
	onChange,
	onFocus,
	options,
	value,
}) => (
	<div className="ddm-radio" onBlur={onBlur} onFocus={onFocus}>
		{options.map(option => (
			<ClayRadio
				checked={value === option.value}
				disabled={disabled}
				inline={inline}
				key={option.value}
				label={option.label}
				name={name}
				onChange={onChange}
				value={option.value}
			/>
		))}
	</div>
);

const RadioProxy = connectStore(
	({
		emit,
		options = [
			{
				label: 'Option 1',
			},
			{
				label: 'Option 2',
			},
		],
		predefinedValue,
		value,
		readOnly,
		inline,
		name,
		...otherProps
	}) => {
		const predefinedValueMemo = useMemo(() => {
			const predefinedValueJSONArray =
				setJSONArrayValue(predefinedValue) || [];

			return predefinedValueJSONArray[0];
		}, [predefinedValue]);

		return (
			<FieldBaseProxy {...otherProps} name={name} readOnly={readOnly}>
				<Radio
					disabled={readOnly}
					inline={inline}
					name={name}
					onBlur={event =>
						emit('fieldBlurred', event, event.target.value)
					}
					onChange={event => emit('fieldFocused', event)}
					onFocus={event =>
						emit('fieldEdited', event, event.target.value)
					}
					options={options}
					value={value ? value : predefinedValueMemo}
				/>
			</FieldBaseProxy>
		);
	}
);

const ReactRadioAdapter = getConnectedReactComponentAdapter(
	RadioProxy,
	templates
);

export {ReactRadioAdapter};
export default ReactRadioAdapter;
