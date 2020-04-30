/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ADD_MAPPED_INFO_ITEM} from '../actions/types';

export const INITIAL_STATE = [];

export default function mappedInfoItemsReducer(
	mappedInfoItems = INITIAL_STATE,
	action
) {
	switch (action.type) {
		case ADD_MAPPED_INFO_ITEM:
			return [
				...mappedInfoItems,
				{
					className: action.className,
					classNameId: action.classNameId,
					classPK: action.classPK,
					title: action.title,
				},
			];

		default:
			return mappedInfoItems;
	}
}
