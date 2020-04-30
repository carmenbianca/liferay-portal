/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import addFragmentEntryLinkComment from '../actions/addFragmentEntryLinkComment';
import FragmentService from '../services/FragmentService';

export default function addFragmentComment({
	body,
	fragmentEntryLinkId,
	parentCommentId = undefined,
}) {
	return dispatch => {
		return FragmentService.addComment({
			body,
			fragmentEntryLinkId,
			onNetworkStatus: dispatch,
			parentCommentId,
		}).then(fragmentEntryLinkComment => {
			dispatch(
				addFragmentEntryLinkComment({
					fragmentEntryLinkComment,
					fragmentEntryLinkId,
					parentCommentId,
				})
			);
		});
	};
}
