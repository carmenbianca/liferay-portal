/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {LAYOUT_DATA_ITEM_TYPE_LABELS} from '../../config/constants/layoutDataItemTypeLabels';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';

export default function getLabelName(item, fragmentEntryLinks) {
	let name;

	if (item.type === LAYOUT_DATA_ITEM_TYPES.fragment) {
		name = fragmentEntryLinks[item.config.fragmentEntryLinkId].name;
	}
	else if (item.type === LAYOUT_DATA_ITEM_TYPES.collectionItem) {
		name = LAYOUT_DATA_ITEM_TYPE_LABELS.collectionItem;
	}
	else if (item.type === LAYOUT_DATA_ITEM_TYPES.collection) {
		name = LAYOUT_DATA_ITEM_TYPE_LABELS.collection;
	}
	else if (item.type === LAYOUT_DATA_ITEM_TYPES.container) {
		name = LAYOUT_DATA_ITEM_TYPE_LABELS.container;
	}
	else if (item.type === LAYOUT_DATA_ITEM_TYPES.column) {
		name = LAYOUT_DATA_ITEM_TYPE_LABELS.column;
	}
	else if (item.type === LAYOUT_DATA_ITEM_TYPES.dropZone) {
		name = LAYOUT_DATA_ITEM_TYPE_LABELS.dropZone;
	}
	else if (item.type === LAYOUT_DATA_ITEM_TYPES.row) {
		name = LAYOUT_DATA_ITEM_TYPE_LABELS.row;
	}

	return name;
}
