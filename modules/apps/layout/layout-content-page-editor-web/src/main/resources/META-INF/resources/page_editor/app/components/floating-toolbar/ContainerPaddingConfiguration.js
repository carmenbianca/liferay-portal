/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClaySelectWithOption} from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import {CONTAINER_PADDING_IDENTIFIERS} from '../../config/constants/containerPaddingIdentifiers';
import {config} from '../../config/index';

export const ContainerPaddingVerticalConfiguration = ({
	onValueChange,
	paddingBottom,
	paddingTop,
}) => (
	<ClayForm.Group className="form-group-autofit" small>
		<div className="form-group-item">
			<label htmlFor="containerPaddingTop">
				{Liferay.Language.get('padding-top')}
			</label>
			<ClaySelectWithOption
				aria-label={Liferay.Language.get('padding-top')}
				id="containerPaddingTop"
				onChange={({target: {value}}) =>
					onValueChange({
						[CONTAINER_PADDING_IDENTIFIERS.paddingTop]: Number(
							value
						),
					})
				}
				options={config.paddingOptions}
				value={String(paddingTop)}
			/>
		</div>

		<div className="form-group-item">
			<label htmlFor="containerPaddingBottom">
				{Liferay.Language.get('padding-bottom')}
			</label>
			<ClaySelectWithOption
				aria-label={Liferay.Language.get('padding-bottom')}
				id="containerPaddingBottom"
				onChange={({target: {value}}) =>
					onValueChange({
						[CONTAINER_PADDING_IDENTIFIERS.paddingBottom]: Number(
							value
						),
					})
				}
				options={config.paddingOptions}
				value={String(paddingBottom)}
			/>
		</div>
	</ClayForm.Group>
);

ContainerPaddingVerticalConfiguration.propTypes = {
	onValueChange: PropTypes.func.isRequired,
	paddingBottom: PropTypes.number,
	paddingTop: PropTypes.number,
};

export const ContainerPaddingHorizontalConfiguration = ({
	onValueChange,
	paddingHorizontal,
}) => (
	<ClayForm.Group className="form-group-autofit" small>
		<div className="form-group-item">
			<label htmlFor="containerPaddingHorizontal">
				{Liferay.Language.get('padding-horizontal')}
			</label>
			<ClaySelectWithOption
				aria-label={Liferay.Language.get('padding-horizontal')}
				id="containerPaddingHorizontal"
				onChange={({target: {value}}) =>
					onValueChange({
						[CONTAINER_PADDING_IDENTIFIERS.paddingHorizontal]: Number(
							value
						),
					})
				}
				options={config.paddingOptions}
				value={String(paddingHorizontal)}
			/>
		</div>
	</ClayForm.Group>
);

ContainerPaddingVerticalConfiguration.propTypes = {
	onValueChange: PropTypes.func.isRequired,
	paddingHorizontal: PropTypes.number,
};
