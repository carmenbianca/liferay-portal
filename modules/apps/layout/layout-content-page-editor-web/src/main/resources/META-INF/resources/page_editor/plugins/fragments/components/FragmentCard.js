/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

import {useSelectItem} from '../../../app/components/Controls';
import {LAYOUT_DATA_ITEM_TYPES} from '../../../app/config/constants/layoutDataItemTypes';
import {useDispatch, useSelector} from '../../../app/store/index';
import addFragment from '../../../app/thunks/addFragment';
import {useItemDrag} from '../../../app/utils/useItemDrag';

const ImagePreview = ({imagePreviewURL}) => {
	if (imagePreviewURL) {
		return (
			<div className="page-editor__fragments__fragment-card-preview">
				<img alt="thumbnail" src={imagePreviewURL} />
			</div>
		);
	}

	return (
		<div className="page-editor__fragments__fragment-card-no-preview">
			<ClayIcon symbol="picture" />
		</div>
	);
};

export default function FragmentCard({
	fragmentEntryKey,
	groupId,
	imagePreviewURL,
	name,
	type,
}) {
	const dispatch = useDispatch();
	const store = useSelector(state => state);
	const selectItem = useSelectItem();

	const dragRef = useItemDrag({
		name,
		onDragEnd: (parentId, position) => {
			dispatch(
				addFragment({
					fragmentEntryKey,
					groupId,
					parentItemId: parentId,
					position,
					selectItem,
					store,
					type,
				})
			);
		},
		type: LAYOUT_DATA_ITEM_TYPES.fragment,
	});

	return (
		<div
			className={classNames(
				'page-editor__fragments__fragment-card',
				'card',
				'card-interactive',
				'card-interactive-secondary',
				'selector-button',
				'overflow-hidden'
			)}
			ref={dragRef}
		>
			<ImagePreview imagePreviewURL={imagePreviewURL} />

			<div className="card-body">
				<div className="card-row">
					<div className="autofit-col autofit-col-expand autofit-row-center">
						<div className="card-title text-truncate">{name}</div>
					</div>
				</div>
			</div>
		</div>
	);
}

FragmentCard.propTypes = {
	imagePreviewURL: PropTypes.string,
	name: PropTypes.string.isRequired,
	type: PropTypes.oneOfType([PropTypes.number, PropTypes.string]),
};
