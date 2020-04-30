/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClayInput, ClaySelectWithOption} from '@clayui/form';
import React from 'react';

import {config} from '../../../app/config/index';
import CollectionSelector from '../../../common/components/CollectionSelector';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';
import selectPrefixedSegmentsExperienceId from '../../selectors/selectPrefixedSegmentsExperienceId';
import {useDispatch, useSelector} from '../../store/index';
import updateItemConfig from '../../thunks/updateItemConfig';

const LAYOUT_OPTIONS = [
	{label: Liferay.Language.get('full-width'), value: '1'},
	{label: Liferay.Util.sub(Liferay.Language.get('x-columns'), 2), value: '2'},
	{label: Liferay.Util.sub(Liferay.Language.get('x-columns'), 3), value: '3'},
	{label: Liferay.Util.sub(Liferay.Language.get('x-columns'), 4), value: '4'},
	{label: Liferay.Util.sub(Liferay.Language.get('x-columns'), 5), value: '5'},
	{label: Liferay.Util.sub(Liferay.Language.get('x-columns'), 6), value: '6'},
];

function collectionIsMapped(collectionConfig) {
	return collectionConfig.collection;
}

export const CollectionConfigurationPanel = ({item}) => {
	const dispatch = useDispatch();
	const segmentsExperienceId = useSelector(
		selectPrefixedSegmentsExperienceId
	);

	const collectionConfig = {
		...LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[
			LAYOUT_DATA_ITEM_TYPES.collection
		],
		...item.config,
	};

	const handleConfigurationChanged = itemConfig => {
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
			<ClayForm.Group small>
				<CollectionSelector
					collectionTitle={collectionConfig.collection.title}
					itemSelectorURL={config.collectionSelectorURL}
					label={Liferay.Language.get('collection')}
					onCollectionSelect={collection =>
						handleConfigurationChanged({
							collection,
						})
					}
				/>
			</ClayForm.Group>
			{collectionIsMapped(item.config) && (
				<>
					<ClayForm.Group small>
						<label htmlFor="collectionLayout">
							{Liferay.Language.get('layout')}
						</label>
						<ClaySelectWithOption
							aria-label={Liferay.Language.get('layout')}
							id="collectionLayout"
							onChange={({target: {value}}) =>
								handleConfigurationChanged({
									numberOfColumns: value,
								})
							}
							options={LAYOUT_OPTIONS}
							value={item.config.numberOfColumns}
						/>
					</ClayForm.Group>

					<ClayForm.Group small>
						<label htmlFor="collectionNumberOfItems">
							{Liferay.Language.get('max-number-of-items')}
						</label>
						<ClayInput
							id="collectionNumberOfItems"
							min={1}
							onChange={({target: {value}}) =>
								handleConfigurationChanged({
									numberOfItems: value,
								})
							}
							type="number"
							value={collectionConfig.numberOfItems}
						/>
					</ClayForm.Group>
				</>
			)}
		</>
	);
};
