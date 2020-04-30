/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_LAYOUT_DATA} from './types';

export default function updateLayoutData({
	addedFragmentEntryLinks = [],
	deletedFragmentEntryLinkIds = [],
	layoutData,
}) {
	return {
		addedFragmentEntryLinks,
		deletedFragmentEntryLinkIds,
		layoutData,
		type: UPDATE_LAYOUT_DATA,
	};
}
