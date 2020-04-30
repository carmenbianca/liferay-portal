/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayForm, {ClayInput} from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import {openImageSelector} from '../../core/openImageSelector';

export function ImageSelector({
	imageTitle = Liferay.Language.get('none'),
	label,
	onClearButtonPressed,
	onImageSelected,
}) {
	return (
		<>
			<ClayForm.Group>
				<label htmlFor="imageTitle">{label}</label>
				<ClayInput
					id="imageTitle"
					placeholder={Liferay.Language.get('none')}
					readOnly
					sizing="sm"
					value={imageTitle}
				/>
			</ClayForm.Group>
			<ClayButton.Group>
				<div className="btn-group-item">
					<ClayButton
						displayType="secondary"
						onClick={() =>
							openImageSelector(image => {
								onImageSelected(image);
							})
						}
						small
					>
						{Liferay.Language.get('select')}
					</ClayButton>
				</div>
				<div className="btn-group-item">
					<ClayButton
						borderless
						displayType="secondary"
						onClick={onClearButtonPressed}
						small
					>
						{Liferay.Language.get('clear')}
					</ClayButton>
				</div>
			</ClayButton.Group>
		</>
	);
}

ImageSelector.propTypes = {
	imageTitle: PropTypes.string,
	label: PropTypes.string,
	onClearButtonPressed: PropTypes.func.isRequired,
	onImageSelected: PropTypes.func.isRequired,
};
