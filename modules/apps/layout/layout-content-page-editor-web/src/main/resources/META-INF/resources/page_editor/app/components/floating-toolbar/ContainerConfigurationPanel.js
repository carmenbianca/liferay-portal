/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React from 'react';

import {
	BackgroundImagePropTypes,
	getLayoutDataItemPropTypes,
} from '../../../prop-types/index';
import {CONTAINER_TYPES} from '../../config/constants/containerTypes';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';
import selectSegmentsExperienceId from '../../selectors/selectSegmentsExperienceId';
import {useDispatch, useSelector} from '../../store/index';
import updateItemConfig from '../../thunks/updateItemConfig';
import {ContainerBackgroundColorConfiguration} from './ContainerBackgroundColorConfiguration';
import {ContainerBackgroundImageConfiguration} from './ContainerBackgroundImageConfiguration';
import {
	ContainerPaddingHorizontalConfiguration,
	ContainerPaddingVerticalConfiguration,
} from './ContainerPaddingConfiguration';
import {ContainerTypeConfiguration} from './ContainerTypeConfiguration';

export const ContainerConfigurationPanel = ({item}) => {
	const dispatch = useDispatch();
	const segmentsExperienceId = useSelector(selectSegmentsExperienceId);

	const containerConfig = {
		...LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[
			LAYOUT_DATA_ITEM_TYPES.container
		],
		...item.config,
	};

	const handleConfigurationValueChanged = itemConfig => {
		dispatch(
			updateItemConfig({
				itemConfig,
				itemId: item.itemId,
				segmentsExperienceId,
			})
		);
	};

	return (
		<>
			<p className="mb-3 sheet-subtitle">
				{Liferay.Language.get('layout')}
			</p>
			<ContainerTypeConfiguration
				containerType={containerConfig.type}
				onValueChange={handleConfigurationValueChanged}
			/>
			<ContainerPaddingVerticalConfiguration
				onValueChange={handleConfigurationValueChanged}
				paddingBottom={containerConfig.paddingBottom}
				paddingTop={containerConfig.paddingTop}
			/>
			{containerConfig.type === CONTAINER_TYPES.fluid && (
				<ContainerPaddingHorizontalConfiguration
					onValueChange={handleConfigurationValueChanged}
					paddingHorizontal={containerConfig.paddingHorizontal}
				/>
			)}
			<p className="mb-3 sheet-subtitle">
				{Liferay.Language.get('background-color')}
			</p>
			<ContainerBackgroundColorConfiguration
				backgroundColor={containerConfig.backgroundColorCssClass}
				onValueChange={handleConfigurationValueChanged}
			/>
			<p className="mb-3 sheet-subtitle">
				{Liferay.Language.get('background-image')}
			</p>
			<ContainerBackgroundImageConfiguration
				backgroundImage={containerConfig.backgroundImage}
				onValueChange={handleConfigurationValueChanged}
			/>
		</>
	);
};

ContainerConfigurationPanel.propTypes = {
	item: getLayoutDataItemPropTypes({
		config: PropTypes.shape({
			backgroundImage: BackgroundImagePropTypes,
			paddingBottom: PropTypes.number,
			paddingHorizontal: PropTypes.number,
			paddingTop: PropTypes.number,
		}),
	}),
};
