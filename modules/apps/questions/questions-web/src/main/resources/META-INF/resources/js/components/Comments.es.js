/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayForm, {ClayInput} from '@clayui/form';
import React, {useCallback, useState} from 'react';

import {createComment} from '../utils/client.es';
import lang from '../utils/lang.es';
import Comment from './Comment.es';

export default ({
	comments,
	commentsChange,
	entityId,
	showNewComment,
	showNewCommentChange,
}) => {
	const [comment, setComment] = useState('');

	const postComment = () => {
		return createComment(comment, entityId).then(data => {
			setComment('');
			showNewCommentChange(false);
			commentsChange([...comments, data]);
		});
	};

	const _commentChange = useCallback(
		comment => {
			if (commentsChange) {
				return commentsChange([
					...comments.filter(o => o.id !== comment.id),
				]);
			}

			return null;
		},
		[commentsChange, comments]
	);

	return (
		<div>
			{comments.map(comment => (
				<Comment
					comment={comment}
					commentChange={_commentChange}
					key={comment.id}
				/>
			))}

			{showNewComment && (
				<>
					<ClayForm.Group small>
						<ClayInput
							component="textarea"
							// placeholder="Insert your name here"
							onChange={event => setComment(event.target.value)}
							type="text"
							value={comment}
						/>

						{comment.length < 15 && (
							<p className="float-right small text-secondary">
								{lang.sub(
									Liferay.Language.get('x-characters-left'),
									[15 - comment.length]
								)}
							</p>
						)}

						<ClayButton.Group className="c-mt-3" spaced>
							<ClayButton
								disabled={comment.length < 15}
								displayType="primary"
								onClick={postComment}
							>
								{Liferay.Language.get('reply')}
							</ClayButton>

							<ClayButton
								displayType="secondary"
								onClick={() => showNewCommentChange(false)}
							>
								{Liferay.Language.get('cancel')}
							</ClayButton>
						</ClayButton.Group>
					</ClayForm.Group>
				</>
			)}
		</div>
	);
};
