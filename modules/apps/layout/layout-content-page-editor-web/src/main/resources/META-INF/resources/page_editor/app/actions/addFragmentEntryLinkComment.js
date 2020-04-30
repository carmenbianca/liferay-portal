/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ADD_FRAGMENT_ENTRY_LINK_COMMENT} from './types';

export default function addFragmentEntryLinkComment({
	fragmentEntryLinkComment,
	fragmentEntryLinkId,
	parentCommentId,
}) {
	return {
		fragmentEntryLinkComment,
		fragmentEntryLinkId,
		parentCommentId,
		type: ADD_FRAGMENT_ENTRY_LINK_COMMENT,
	};
}
