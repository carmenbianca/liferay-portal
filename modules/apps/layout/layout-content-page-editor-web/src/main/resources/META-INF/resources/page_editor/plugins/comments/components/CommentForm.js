/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import PropTypes from 'prop-types';
import React from 'react';

import Button from '../../../common/components/Button';
import Editor from '../../../common/components/Editor';
import InvisibleFieldset from '../../../common/components/InvisibleFieldset';

export default function CommentForm({
	autoFocus = false,
	id,
	loading = false,
	onCancelButtonClick,
	onFormFocus = () => {},
	onSubmitButtonClick,
	onTextareaChange,
	showButtons = false,
	submitButtonLabel,
	textareaContent,
}) {
	return (
		<form onFocus={onFormFocus}>
			<InvisibleFieldset disabled={loading}>
				<div className="form-group form-group-sm">
					<label className="sr-only" htmlFor={id}>
						{Liferay.Language.get('add-comment')}
					</label>

					<Editor
						autoFocus={autoFocus}
						configurationName="comment"
						id={id}
						initialValue={textareaContent}
						onChange={onTextareaChange}
						placeholder={Liferay.Language.get(
							'type-your-comment-here'
						)}
					/>
				</div>

				{showButtons && (
					<ClayButton.Group className="mb-3" spaced>
						<Button
							disabled={!textareaContent}
							displayType="primary"
							loading={loading}
							onClick={onSubmitButtonClick}
							small
						>
							{submitButtonLabel}
						</Button>

						<Button
							displayType="secondary"
							onClick={onCancelButtonClick}
							small
							type="button"
						>
							{Liferay.Language.get('cancel')}
						</Button>
					</ClayButton.Group>
				)}
			</InvisibleFieldset>
		</form>
	);
}

CommentForm.propTypes = {
	autoFocus: PropTypes.bool,
	id: PropTypes.string,
	loading: PropTypes.bool,
	onCancelButtonClick: PropTypes.func.isRequired,
	onFormFocus: PropTypes.func,
	onSubmitButtonClick: PropTypes.func.isRequired,
	onTextareaChange: PropTypes.func.isRequired,
	showButtons: PropTypes.bool,
	submitButtonLabel: PropTypes.string.isRequired,
	textareaContent: PropTypes.string.isRequired,
};
