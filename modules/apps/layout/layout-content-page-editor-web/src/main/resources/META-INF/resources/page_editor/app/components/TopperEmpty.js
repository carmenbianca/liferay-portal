/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import React, {useRef} from 'react';

import {
	LayoutDataPropTypes,
	getLayoutDataItemPropTypes,
} from '../../prop-types/index';
import {LAYOUT_DATA_ITEM_TYPES} from '../config/constants/layoutDataItemTypes';
import selectCanUpdate from '../selectors/selectCanUpdate';
import {useSelector} from '../store/index';
import useDragAndDrop, {TARGET_POSITION} from '../utils/useDragAndDrop';
import {useToControlsId} from './CollectionItemContext';
import getLabelName from './layout-data-items/getLabelName';

export default function({children, ...props}) {
	const canUpdate = useSelector(selectCanUpdate);

	return canUpdate ? (
		<TopperEmpty {...props}>{children}</TopperEmpty>
	) : (
		children
	);
}

function TopperEmpty({children, item, layoutData}) {
	const containerRef = useRef(null);
	const store = useSelector(state => state);
	const fragmentEntryLinks = store.fragmentEntryLinks;

	const toControlsId = useToControlsId();

	const {
		drop,
		isDragging,
		state: {
			dropItem,
			dropTargetItemId,
			droppable,
			targetPositionWithMiddle,
			targetPositionWithoutMiddle,
		},
	} = useDragAndDrop({
		containerRef,
		dropTargetItem: item,
		layoutData,
	});

	const targetPosition =
		item.type === LAYOUT_DATA_ITEM_TYPES.fragment ||
		item.type === LAYOUT_DATA_ITEM_TYPES.collection
			? targetPositionWithoutMiddle
			: targetPositionWithMiddle;

	const isFragment = children.type === React.Fragment;
	const realChildren = isFragment ? children.props.children : children;

	const isDraggableInPosition = position =>
		targetPosition === position &&
		dropTargetItemId === toControlsId(item.itemId);

	const dataAdvice =
		!droppable && isDraggableInPosition(TARGET_POSITION.MIDDLE)
			? Liferay.Util.sub(
					Liferay.Language.get('a-x-cannot-be-dropped-inside-a-x'),
					[
						getLabelName(dropItem, fragmentEntryLinks),
						getLabelName(item, fragmentEntryLinks),
					]
			  )
			: null;

	return React.Children.map(realChildren, child => {
		if (!child) {
			return child;
		}

		return (
			<>
				{React.cloneElement(child, {
					...child.props,
					className: classNames(child.props.className, {
						'drag-over-bottom': isDraggableInPosition(
							TARGET_POSITION.BOTTOM
						),
						'drag-over-middle': isDraggableInPosition(
							TARGET_POSITION.MIDDLE
						),
						'drag-over-top': isDraggableInPosition(
							TARGET_POSITION.TOP
						),
						dragged: isDragging,
						'not-droppable':
							!droppable &&
							isDraggableInPosition(TARGET_POSITION.MIDDLE),
						'page-editor__topper': true,
					}),
					'data-advice': dataAdvice,
					ref: node => {
						containerRef.current = node;
						drop(node);

						// Call the original ref, if any.
						if (typeof child.ref === 'function') {
							child.ref(node);
						}
					},
				})}
			</>
		);
	});
}

TopperEmpty.propTypes = {
	item: getLayoutDataItemPropTypes().isRequired,
	layoutData: LayoutDataPropTypes.isRequired,
};
