/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import './CheckboxRegister.soy';

import {ClayCheckbox} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import React, {useState} from 'react';

import {FieldBaseProxy} from '../FieldBase/ReactFieldBase.es';
import getConnectedReactComponentAdapter from '../util/ReactComponentAdapter.es';
import {connectStore} from '../util/connectStore.es';
import templates from './CheckboxAdapter.soy';

const Switcher = ({
	checked: initialChecked,
	disabled,
	label,
	name,
	onChange,
	required,
	showLabel,
	spritemap,
}) => {
	const [checked, setChecked] = useState(initialChecked);

	return (
		<label className="ddm-toggle-switch toggle-switch">
			<input
				checked={checked}
				className="toggle-switch-check"
				disabled={disabled}
				name={name}
				onChange={event => {
					setChecked(event.target.checked);
					onChange(event, event.target.checked);
				}}
				type="checkbox"
				value={true}
			/>

			<span aria-hidden="true" className="toggle-switch-bar">
				<span className="toggle-switch-handle"></span>

				{(showLabel || required) && (
					<span className="toggle-switch-text toggle-switch-text-right">
						{showLabel && label}

						{required && (
							<ClayIcon
								className="reference-mark"
								spritemap={spritemap}
								symbol="asterisk"
							/>
						)}
					</span>
				)}
			</span>
		</label>
	);
};

const Checkbox = ({
	checked: initialChecked,
	disabled,
	label,
	name,
	onChange,
	required,
	showLabel,
	spritemap,
}) => {
	const [checked, setChecked] = useState(initialChecked);

	return (
		<ClayCheckbox
			checked={checked}
			disabled={disabled}
			label={showLabel && label}
			name={name}
			onChange={event => {
				setChecked(event.target.checked);
				onChange(event, event.target.checked);
			}}
		>
			{showLabel && required && (
				<ClayIcon
					className="reference-mark"
					spritemap={spritemap}
					symbol="asterisk"
				/>
			)}
		</ClayCheckbox>
	);
};

const CheckboxProxy = connectStore(
	({
		disabled,
		dispatch,
		emit,
		label,
		name,
		required,
		showAsSwitcher = true,
		showLabel = true,
		spritemap,
		value = true,
		...otherProps
	}) => {
		const Toggle = showAsSwitcher ? Switcher : Checkbox;

		return (
			<FieldBaseProxy
				dispatch={dispatch}
				label={label}
				name={name}
				required={required}
				showLabel={false}
				spritemap={spritemap}
				{...otherProps}
			>
				<Toggle
					checked={value}
					disabled={disabled}
					label={label}
					name={name}
					onChange={(event, value) =>
						emit('fieldEdited', event, value)
					}
					required={required}
					showLabel={showLabel}
					spritemap={spritemap}
				/>
			</FieldBaseProxy>
		);
	}
);

const ReactCheckboxAdapter = getConnectedReactComponentAdapter(
	CheckboxProxy,
	templates
);

export {ReactCheckboxAdapter};
export default ReactCheckboxAdapter;
