/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useRef} from 'react';
import {useDragLayer} from 'react-dnd';

const getItemStyles = (currentOffset, ref) => {
	if (!currentOffset || !ref.current) {
		return {
			display: 'none',
		};
	}

	const rect = ref.current.getBoundingClientRect();
	const x = currentOffset.x - rect.width * 0.5;
	const y = currentOffset.y - rect.height * 0.5;
	const transform = `translate(${x}px, ${y}px)`;

	return {
		WebkitTransform: transform,
		transform,
	};
};

export default function DragPreview() {
	const ref = useRef();

	const {currentOffset, isDragging, item} = useDragLayer(monitor => ({
		currentOffset: monitor.getClientOffset(),
		isDragging: monitor.isDragging(),
		item: monitor.getItem(),
	}));

	if (!isDragging) {
		return null;
	}

	return (
		<div className="page-editor__drag-preview">
			<div
				className="page-editor__drag-preview__content"
				ref={ref}
				style={getItemStyles(currentOffset, ref)}
			>
				{item && item.name
					? item.name
					: Liferay.Language.get('element')}
			</div>
		</div>
	);
}
