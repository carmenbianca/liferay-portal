/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClayCheckbox} from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import {ConfigurationFieldPropTypes} from '../../../prop-types/index';

export const CheckboxField = ({field, onValueSelect, value}) => (
	<ClayForm.Group>
		<ClayCheckbox
			aria-label={field.label}
			checked={value}
			label={field.label}
			onChange={event => {
				onValueSelect(field.name, event.target.checked);
			}}
		/>
	</ClayForm.Group>
);

CheckboxField.propTypes = {
	field: PropTypes.shape(ConfigurationFieldPropTypes).isRequired,
	onValueSelect: PropTypes.func.isRequired,
	value: PropTypes.oneOfType([PropTypes.bool, PropTypes.string]),
};
