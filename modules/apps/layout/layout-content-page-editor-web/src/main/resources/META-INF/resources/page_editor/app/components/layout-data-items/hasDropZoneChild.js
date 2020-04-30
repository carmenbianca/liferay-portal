/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';

export default function hasDropZoneChild(item, layoutData) {
	return item.children.some(childrenId => {
		const children = layoutData.items[childrenId];

		return children.type === LAYOUT_DATA_ITEM_TYPES.dropZone
			? true
			: hasDropZoneChild(children, layoutData);
	});
}
