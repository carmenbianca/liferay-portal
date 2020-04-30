/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	ADD_FRAGMENT_ENTRY_LINKS,
	UPDATE_COL_SIZE,
	UPDATE_LAYOUT_DATA,
} from '../actions/types';

export const INITIAL_STATE = {
	items: {},
};

export default function layoutDataReducer(layoutData = INITIAL_STATE, action) {
	switch (action.type) {
		case UPDATE_COL_SIZE: {
			let items = layoutData.items;

			if (action.itemId in items) {
				items = {
					...items,
					[action.itemId]: {
						...items[action.itemId],
						config: {
							...items[action.itemId].config,
							size: action.size,
						},
					},
				};

				if (action.nextColumnItemId in items) {
					items = {
						...items,
						[action.nextColumnItemId]: {
							...items[action.nextColumnItemId],
							config: {
								...items[action.nextColumnItemId].config,
								size: action.nextColumnSize,
							},
						},
					};
				}
			}

			return {
				...layoutData,
				items,
			};
		}

		case UPDATE_LAYOUT_DATA:
		case ADD_FRAGMENT_ENTRY_LINKS:
			return action.layoutData;

		default:
			return layoutData;
	}
}
