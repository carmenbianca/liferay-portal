/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DELETE_FRAGMENT_ENTRY_LINK_COMMENT} from './types';

export default function deleteFragmentEntryLinkComment({
	commentId,
	fragmentEntryLinkId,
	parentCommentId,
}) {
	return {
		commentId,
		fragmentEntryLinkId,
		parentCommentId,
		type: DELETE_FRAGMENT_ENTRY_LINK_COMMENT,
	};
}
