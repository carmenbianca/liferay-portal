/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_COL_SIZE} from './types';

export default function updateColSize({
	itemId,
	nextColumnItemId,
	nextColumnSize,
	size,
}) {
	return {
		itemId,
		nextColumnItemId,
		nextColumnSize,
		size,
		type: UPDATE_COL_SIZE,
	};
}
