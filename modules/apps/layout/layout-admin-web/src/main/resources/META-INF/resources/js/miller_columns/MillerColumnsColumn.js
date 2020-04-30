/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import React, {useEffect, useRef} from 'react';
import {useDrop} from 'react-dnd';

import MillerColumnsItem from './MillerColumnsItem';
import {ACCEPTING_TYPES} from './constants';

const isValidTarget = (source, parent) => {
	return !!(
		parent &&
		(source.columnIndex > parent.columnIndex + 1 ||
			(source.columnIndex === parent.columnIndex + 1 &&
				source.itemIndex < parent.childrenCount - 1) ||
			(parent.parentable &&
				source.columnIndex <= parent.columnIndex &&
				!source.active))
	);
};

const MillerColumnsColumn = ({
	actionHandlers,
	items = [],
	namespace,
	onItemDrop,
	onItemStayHover,
	parent,
}) => {
	const ref = useRef();

	const [{canDrop}, drop] = useDrop({
		accept: ACCEPTING_TYPES.ITEM,
		canDrop(source, monitor) {
			return (
				monitor.isOver({shallow: true}) && isValidTarget(source, parent)
			);
		},
		collect: monitor => ({
			canDrop: !!monitor.canDrop(),
		}),
		drop(source) {
			if (canDrop) {
				onItemDrop(source.id, parent.id);
			}
		},
	});

	useEffect(() => {
		drop(ref);
	}, [drop]);

	return (
		<ul
			className={classNames(
				'col-11 col-lg-4 col-md-6 miller-columns-col show-quick-actions-on-hover',
				{
					'drop-target': canDrop,
				}
			)}
			ref={ref}
		>
			{items.map((item, index) => (
				<MillerColumnsItem
					actionHandlers={actionHandlers}
					item={{...item, itemIndex: index}}
					key={item.key}
					namespace={namespace}
					onItemDrop={onItemDrop}
					onItemStayHover={onItemStayHover}
				/>
			))}
		</ul>
	);
};

export default MillerColumnsColumn;
