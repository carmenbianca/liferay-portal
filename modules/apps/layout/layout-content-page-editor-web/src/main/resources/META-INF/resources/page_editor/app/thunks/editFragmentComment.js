/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import editFragmentEntryLinkComment from '../actions/editFragmentEntryLinkComment';
import FragmentService from '../services/FragmentService';

export default function editFragmentComment({
	body,
	commentId,
	fragmentEntryLinkId,
	parentCommentId,
	resolved = false,
}) {
	return dispatch => {
		return FragmentService.editComment({
			body,
			commentId,
			onNetworkStatus: dispatch,
			resolved,
		}).then(fragmentEntryLinkComment => {
			dispatch(
				editFragmentEntryLinkComment({
					fragmentEntryLinkComment,
					fragmentEntryLinkId,
					parentCommentId,
				})
			);
		});
	};
}
