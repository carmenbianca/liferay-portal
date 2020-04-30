/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClaySelectWithOption} from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import {CONTAINER_PADDING_IDENTIFIERS} from '../../config/constants/containerPaddingIdentifiers';
import {CONTAINER_TYPES} from '../../config/constants/containerTypes';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';

const CONTAINER_TYPE_IDENTIFIER = 'type';

export const ContainerTypeConfiguration = ({containerType, onValueChange}) => (
	<ClayForm.Group small>
		<label htmlFor="containerType">
			{Liferay.Language.get('container')}
		</label>
		<ClaySelectWithOption
			aria-label={Liferay.Language.get('container')}
			id="containerType"
			onChange={({target: {value}}) => {
				if (value === CONTAINER_TYPES.fluid) {
					onValueChange({
						[CONTAINER_PADDING_IDENTIFIERS.paddingHorizontal]:
							LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[
								LAYOUT_DATA_ITEM_TYPES.container
							].paddingHorizontal,
						[CONTAINER_TYPE_IDENTIFIER]: value,
					});
				}
				else {
					onValueChange({[CONTAINER_TYPE_IDENTIFIER]: value});
				}
			}}
			options={[
				{
					label: Liferay.Language.get('fixed-width'),
					value: CONTAINER_TYPES.fixed,
				},
				{
					label: Liferay.Language.get('fluid'),
					value: CONTAINER_TYPES.fluid,
				},
			]}
			value={containerType}
		/>
	</ClayForm.Group>
);

ContainerTypeConfiguration.propTypes = {
	containerType: PropTypes.string.isRequired,
	onValueChange: PropTypes.func.isRequired,
};
