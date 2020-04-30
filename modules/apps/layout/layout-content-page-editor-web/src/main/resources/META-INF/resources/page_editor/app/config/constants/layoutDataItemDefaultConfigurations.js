/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {CONTAINER_TYPES} from './containerTypes';
import {LAYOUT_DATA_ITEM_TYPES} from './layoutDataItemTypes';

export const LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS = {
	[LAYOUT_DATA_ITEM_TYPES.collection]: {
		collection: {},
		numberOfColumns: 1,
		numberOfItems: 5,
	},

	[LAYOUT_DATA_ITEM_TYPES.column]: {
		size: 0,
	},

	[LAYOUT_DATA_ITEM_TYPES.container]: {
		backgroundColorCssClass: '',
		backgroundImage: {},
		paddingBottom: 3,
		paddingHorizontal: 3,
		paddingTop: 3,
		type: CONTAINER_TYPES.fixed,
	},

	[LAYOUT_DATA_ITEM_TYPES.fragment]: {
		fragmentEntryLinkId: '',
	},

	[LAYOUT_DATA_ITEM_TYPES.root]: {},

	[LAYOUT_DATA_ITEM_TYPES.row]: {
		gutters: true,
		numberOfColumns: 3,
	},
};
