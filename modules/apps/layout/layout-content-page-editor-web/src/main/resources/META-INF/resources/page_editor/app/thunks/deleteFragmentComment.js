/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import deleteFragmentEntryLinkComment from '../actions/deleteFragmentEntryLinkComment';
import FragmentService from '../services/FragmentService';

export default function deleteFragmentComment({
	commentId,
	fragmentEntryLinkId,
	parentCommentId,
}) {
	return dispatch => {
		return FragmentService.deleteComment({
			commentId,
			onNetworkStatus: dispatch,
		}).then(() => {
			dispatch(
				deleteFragmentEntryLinkComment({
					commentId,
					fragmentEntryLinkId,
					parentCommentId,
				})
			);
		});
	};
}
