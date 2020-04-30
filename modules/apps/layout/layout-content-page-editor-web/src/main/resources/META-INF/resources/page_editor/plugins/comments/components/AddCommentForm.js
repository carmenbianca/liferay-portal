/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {openToast} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React, {useState} from 'react';

import {useDispatch} from '../../../app/store/index';
import addFragmentComment from '../../../app/thunks/addFragmentComment';
import CommentForm from './CommentForm';

export default function AddCommentForm({fragmentEntryLinkId}) {
	const [addingComment, setAddingComment] = useState(false);
	const [showButtons, setShowButtons] = useState(false);
	const [textareaContent, setTextareaContent] = useState('');
	const dispatch = useDispatch();

	const _handleCancelButtonClick = () => {
		setShowButtons(false);
		setTextareaContent('');
	};

	const _handleFormFocus = () => {
		setShowButtons(true);
	};

	const _handleCommentButtonClick = () => {
		setAddingComment(true);

		dispatch(
			addFragmentComment({
				body: textareaContent,
				fragmentEntryLinkId,
			})
		)
			.then(() => {
				setAddingComment(false);
				setShowButtons(false);
				setTextareaContent('');
			})
			.catch(() => {
				openToast({
					message: Liferay.Language.get(
						'the-comment-could-not-be-saved'
					),
					title: Liferay.Language.get('error'),
					type: 'danger',
				});

				setAddingComment(false);
			});
	};

	const _handleTextareaChange = content => {
		if (content) {
			setTextareaContent(content);
		}
	};

	return (
		<div className="px-3">
			<CommentForm
				id="pageEditorCommentEditor"
				loading={addingComment}
				onCancelButtonClick={_handleCancelButtonClick}
				onFormFocus={_handleFormFocus}
				onSubmitButtonClick={_handleCommentButtonClick}
				onTextareaChange={_handleTextareaChange}
				showButtons={showButtons}
				submitButtonLabel={Liferay.Language.get('comment')}
				textareaContent={textareaContent}
			/>
		</div>
	);
}

AddCommentForm.propTypes = {
	fragmentEntryLinkId: PropTypes.string.isRequired,
};
