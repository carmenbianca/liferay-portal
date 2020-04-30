/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayCheckbox} from '@clayui/form';
import React from 'react';

import toggleShowResolvedComments from '../../../app/actions/toggleShowResolvedComments';
import {useDispatch, useSelector} from '../../../app/store/index';

export default function ResolvedCommentsToggle() {
	const dispatch = useDispatch();

	const showResolvedComments = useSelector(
		state => !!state.showResolvedComments
	);

	const hasResolvedComments = useSelector(state =>
		Object.values(state.fragmentEntryLinks || {}).some(
			fragmentEntryLink =>
				fragmentEntryLink.comments &&
				fragmentEntryLink.comments.some(comment => comment.resolved)
		)
	);

	return (
		<div className="pb-3 px-3">
			<ClayCheckbox
				checked={showResolvedComments}
				disabled={!showResolvedComments && !hasResolvedComments}
				label={Liferay.Language.get('show-resolved-comments')}
				onChange={event =>
					dispatch(
						toggleShowResolvedComments({
							showResolvedComments: Boolean(event.target.checked),
						})
					)
				}
			/>
		</div>
	);
}
