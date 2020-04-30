/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React from 'react';

import {config} from '../../app/config/index';
import ItemSelector from './ItemSelector';

export default function CollectionSelector({
	collectionTitle,
	itemSelectorURL,
	label,
	onCollectionSelect,
}) {
	const eventName = `${config.portletNamespace}selectInfoList`;

	return (
		<ItemSelector
			eventName={eventName}
			itemSelectorURL={itemSelectorURL || config.infoListSelectorURL}
			label={label}
			onItemSelect={onCollectionSelect}
			selectedItemTitle={collectionTitle}
			showMappedItems={false}
		/>
	);
}

CollectionSelector.propTypes = {
	collectionTitle: PropTypes.string,
	label: PropTypes.string,
	onCollectionSelect: PropTypes.func.isRequired,
};
