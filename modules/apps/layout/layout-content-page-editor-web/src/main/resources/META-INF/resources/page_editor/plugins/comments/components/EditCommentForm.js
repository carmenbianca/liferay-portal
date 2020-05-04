/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {openToast} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React, {useState} from 'react';

import {useDispatch} from '../../../app/store/index';
import editFragmentComment from '../../../app/thunks/editFragmentComment';
import CommentForm from './CommentForm';

export default function EditCommentForm({
	comment,
	fragmentEntryLinkId,
	onCloseForm,
}) {
	const [editingComment, setEditingComment] = useState(false);
	const [textareaContent, setTextareaContent] = useState(comment.body);
	const dispatch = useDispatch();

	const _handleCommentButtonClick = () => {
		setEditingComment(true);

		dispatch(
			editFragmentComment({
				body: textareaContent,
				commentId: comment.commentId,
				fragmentEntryLinkId,
				parentCommentId: comment.parentCommentId,
			})
		)
			.then(() => {
				setEditingComment(false);

				onCloseForm();
			})
			.catch(() => {
				openToast({
					message: Liferay.Language.get(
						'the-comment-could-not-be-edited'
					),
					title: Liferay.Language.get('error'),
					type: 'danger',
				});

				setEditingComment(false);
			});
	};

	return (
		<CommentForm
			autoFocus
			id={`pageEditorCommentEditor_${comment.commentId}`}
			loading={editingComment}
			onCancelButtonClick={() => onCloseForm()}
			onSubmitButtonClick={_handleCommentButtonClick}
			onTextareaChange={content => setTextareaContent(content)}
			showButtons
			submitButtonLabel={Liferay.Language.get('update')}
			textareaContent={textareaContent}
		/>
	);
}

EditCommentForm.propTypes = {
	comment: PropTypes.shape({
		body: PropTypes.string.isRequired,
		commentId: PropTypes.string.isRequired,
	}),
	onCloseForm: PropTypes.func.isRequired,
};
