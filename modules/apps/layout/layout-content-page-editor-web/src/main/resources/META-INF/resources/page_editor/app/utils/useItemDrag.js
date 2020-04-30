/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useEffect} from 'react';
import {useDrag} from 'react-dnd';
import {getEmptyImage} from 'react-dnd-html5-backend';

import {useSelectItem} from '../components/Controls';

export function useItemDrag({canDrag = () => true, type, name, onDragEnd}) {
	const selectItem = useSelectItem();

	const [, dragRef, preview] = useDrag({
		begin() {
			selectItem(null);
		},

		canDrag(...args) {
			return canDrag(...args);
		},

		end(_item, monitor) {
			const result = monitor.getDropResult();

			if (!result) {
				return;
			}

			const {parentId, position} = result;

			if (parentId) {
				onDragEnd(parentId, position);
			}
		},

		item: {
			name,
			type,
		},
	});

	useEffect(() => {
		preview(getEmptyImage(), {captureDraggingState: true});
	}, [preview]);

	return dragRef;
}
