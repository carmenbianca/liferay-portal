/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import ColorPalette from '../../../common/components/ColorPalette';

const CONTAINER_BACKGROUND_COLOR_IDENTIFIER = 'backgroundColorCssClass';

export const ContainerBackgroundColorConfiguration = ({
	backgroundColor,
	onValueChange,
}) => (
	<ClayForm.Group>
		<ColorPalette
			onClear={() =>
				onValueChange({
					[CONTAINER_BACKGROUND_COLOR_IDENTIFIER]: '',
				})
			}
			onColorSelect={value =>
				onValueChange({[CONTAINER_BACKGROUND_COLOR_IDENTIFIER]: value})
			}
			selectedColor={backgroundColor}
		></ColorPalette>
	</ClayForm.Group>
);

ContainerBackgroundColorConfiguration.propTypes = {
	backgroundColor: PropTypes.string,
	onValueChange: PropTypes.func.isRequired,
};
