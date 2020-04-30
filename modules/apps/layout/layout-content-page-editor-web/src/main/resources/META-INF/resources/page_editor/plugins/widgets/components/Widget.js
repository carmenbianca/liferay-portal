/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import PropTypes from 'prop-types';
import React from 'react';

import {LAYOUT_DATA_ITEM_TYPES} from '../../../app/config/constants/layoutDataItemTypes';
import {useDispatch, useSelector} from '../../../app/store/index';
import addWidget from '../../../app/thunks/addWidget';
import {useItemDrag} from '../../../app/utils/useItemDrag';

export default function Widget({instanceable, portletId, title, used}) {
	const dispatch = useDispatch();
	const store = useSelector(state => state);

	const disabled = used && !instanceable;

	const dragRef = useItemDrag({
		canDrag: () => !disabled,
		name: title,
		onDragEnd: (parentId, position) =>
			dispatch(
				addWidget({
					parentItemId: parentId,
					portletId,
					position,
					store,
				})
			),
		type: LAYOUT_DATA_ITEM_TYPES.fragment,
	});

	return (
		<button
			className="btn btn-sm btn-unstyled d-block mb-1 px-2 py-1"
			disabled={disabled}
			ref={dragRef}
			type="button"
		>
			<ClayIcon
				className="mr-2"
				symbol={instanceable ? 'grid' : 'live'}
			/>
			<span>{title}</span>
		</button>
	);
}

Widget.propTypes = {
	instanceable: PropTypes.bool.isRequired,
	portletId: PropTypes.string.isRequired,
	title: PropTypes.string.isRequired,
	used: PropTypes.bool.isRequired,
};
