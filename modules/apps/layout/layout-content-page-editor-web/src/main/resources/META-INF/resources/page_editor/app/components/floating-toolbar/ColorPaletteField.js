/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import ColorPalette from '../../../common/components/ColorPalette';
import {ConfigurationFieldPropTypes} from '../../../prop-types/index';

export const ColorPaletteField = ({field, onValueSelect, value}) => (
	<ClayForm.Group>
		<ColorPalette
			label={field.label}
			onColorSelect={(color, event) => {
				onValueSelect(field.name, {
					color,
					cssClass: color,
					rgbValue: getComputedStyle(event.target).backgroundColor,
				});
			}}
			selectedColor={value && value.cssClass}
		/>
	</ClayForm.Group>
);

ColorPaletteField.propTypes = {
	field: PropTypes.shape(ConfigurationFieldPropTypes).isRequired,
	onValueSelect: PropTypes.func.isRequired,
	value: PropTypes.shape({
		color: PropTypes.string,
		cssClass: PropTypes.string,
		rgbValue: PropTypes.string,
	}),
};
