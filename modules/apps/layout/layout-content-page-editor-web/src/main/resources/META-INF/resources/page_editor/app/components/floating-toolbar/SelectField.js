/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClaySelectWithOption} from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import {ConfigurationFieldPropTypes} from '../../../prop-types/index';

export const SelectField = ({field, onValueSelect, value}) => (
	<ClayForm.Group small>
		<label htmlFor={field.name}>{field.label}</label>

		<ClaySelectWithOption
			aria-label={field.label}
			id={field.name}
			onChange={event => {
				onValueSelect(
					field.name,
					event.target.options[event.target.selectedIndex].value
				);
			}}
			options={field.typeOptions.validValues}
			value={value || field.defaultValue}
		/>
	</ClayForm.Group>
);

SelectField.propTypes = {
	field: PropTypes.shape({
		...ConfigurationFieldPropTypes,
		typeOptions: PropTypes.shape({
			validValues: PropTypes.arrayOf(
				PropTypes.shape({
					label: PropTypes.string.isRequired,
					value: PropTypes.string.isRequired,
				})
			).isRequired,
		}).isRequired,
	}),

	onValueSelect: PropTypes.func.isRequired,
	value: PropTypes.oneOfType([PropTypes.number, PropTypes.string]),
};
