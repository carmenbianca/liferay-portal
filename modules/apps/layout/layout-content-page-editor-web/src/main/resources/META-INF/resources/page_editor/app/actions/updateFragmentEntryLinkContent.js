/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_FRAGMENT_ENTRY_LINK_CONTENT} from './types';

export default function updateFragmentEntryLinkContent({
	content,
	editableValues,
	fragmentEntryLinkId,
}) {
	return {
		content,
		editableValues,
		fragmentEntryLinkId,
		type: UPDATE_FRAGMENT_ENTRY_LINK_CONTENT,
	};
}
