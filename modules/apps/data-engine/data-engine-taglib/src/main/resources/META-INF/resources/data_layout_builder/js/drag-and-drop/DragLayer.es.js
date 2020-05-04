/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';
import {useDragLayer} from 'react-dnd';

const layerStyles = {
	cursor: 'grabbing',
	height: '100%',
	left: 0,
	pointerEvents: 'none',
	position: 'fixed',
	top: 0,
	width: '100%',
	zIndex: 150,
};

function getItemStyles(initialOffset, currentOffset) {
	if (!initialOffset || !currentOffset) {
		return {
			display: 'none',
		};
	}

	const {x, y} = currentOffset;
	const transform = `translate(${x}px, ${y}px)`;

	return {
		WebkitTransform: transform,
		transform,
	};
}

export default () => {
	const {currentOffset, initialOffset, isDragging, item} = useDragLayer(
		monitor => ({
			currentOffset: monitor.getSourceClientOffset(),
			initialOffset: monitor.getInitialSourceClientOffset(),
			isDragging: monitor.isDragging(),
			item: monitor.getItem(),
			itemType: monitor.getItemType(),
		})
	);

	if (!isDragging) {
		return null;
	}

	const {preview} = item;

	return (
		<div style={{...layerStyles, zIndex: 200}}>
			<div
				style={getItemStyles(initialOffset, currentOffset, isDragging)}
			>
				{preview && preview()}
			</div>
		</div>
	);
};
