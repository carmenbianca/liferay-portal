/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import React from 'react';

import {deleteMessage} from '../utils/client.es';

export default ({comment, commentChange}) => {
	const deleteComment = () => {
		deleteMessage(comment);
		commentChange(comment);
	};

	return (
		<div className="c-my-3 questions-reply row">
			<div className="align-items-md-center col-2 col-md-1 d-flex justify-content-end justify-content-md-center">
				<ClayIcon
					className="c-mt-3 c-mt-md-0 questions-reply-icon text-secondary"
					symbol="reply"
				/>
			</div>

			<div className="col-10 col-lg-11">
				<p className="c-mb-0">
					{comment.articleBody}
					{' - '}
					<span className="font-weight-bold">
						{comment.creator.name}
					</span>
				</p>

				{comment.actions.delete && (
					<ClayButton
						className="c-mt-3 font-weight-bold text-secondary"
						displayType="unstyled"
						onClick={deleteComment}
					>
						{Liferay.Language.get('delete')}
					</ClayButton>
				)}
			</div>
		</div>
	);
};
