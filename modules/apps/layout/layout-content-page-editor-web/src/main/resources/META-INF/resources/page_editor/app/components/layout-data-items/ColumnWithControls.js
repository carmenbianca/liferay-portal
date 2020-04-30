/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useContext, useEffect, useMemo} from 'react';

import {
	LayoutDataPropTypes,
	getLayoutDataItemPropTypes,
} from '../../../prop-types/index';
import {useIsActive} from '../Controls';
import TopperEmpty from '../TopperEmpty';
import Column from './Column';
import {ResizingContext} from './RowWithControls';

const ColumnWithControls = React.forwardRef(
	({children, item, layoutData}, ref) => {
		const isActive = useIsActive();

		const parentItemIsActive = useMemo(
			() =>
				layoutData.items[item.parentId]
					? isActive(item.parentId)
					: false,
			[isActive, item, layoutData]
		);

		const {onResizeEnd, onResizeStart, onResizing} = useContext(
			ResizingContext
		);

		const columnInfo = useMemo(() => getColumnInfo({item, layoutData}), [
			item,
			layoutData,
		]);

		const onWindowMouseMove = event => {
			event.preventDefault();

			onResizing(event, columnInfo);
		};

		const onWindowMouseUp = event => {
			onResizeEnd(event);

			window.removeEventListener('mouseup', onWindowMouseUp);
			window.removeEventListener('mousemove', onWindowMouseMove);
		};

		const onResizeButtonMouseDown = event => {
			onResizeStart(event);

			window.addEventListener('mouseup', onWindowMouseUp);
			window.addEventListener('mousemove', onWindowMouseMove);
		};

		useEffect(
			() => () => {
				window.removeEventListener('mouseup', onWindowMouseUp);
				window.removeEventListener('mousemove', onWindowMouseMove);
			},

			// We just want to ensure that this listeners are removed if
			// the component is unmounted before resizing has ended
			// eslint-disable-next-line react-hooks/exhaustive-deps
			[]
		);

		return (
			<TopperEmpty item={item} layoutData={layoutData}>
				<Column className="page-editor__col" item={item} ref={ref}>
					{parentItemIsActive && !columnInfo.isLastColumn ? (
						<div>
							{children}
							<button
								className="btn-primary page-editor__col__resizer"
								onMouseDown={onResizeButtonMouseDown}
							/>
						</div>
					) : (
						children
					)}
				</Column>
			</TopperEmpty>
		);
	}
);

ColumnWithControls.propTypes = {
	item: getLayoutDataItemPropTypes().isRequired,
	layoutData: LayoutDataPropTypes.isRequired,
};

export default ColumnWithControls;

/**
 * Retrieves necessary data from the current and next column.
 *
 * @param {!Object} options
 * @param {!Object} options.item
 * @param {!Object} options.layoutData
 *
 * @returns {!Object}
 */
function getColumnInfo({item, layoutData}) {
	const rowColumns = layoutData.items[item.parentId].children;
	const colIndex = rowColumns.indexOf(item.itemId);
	const nextColumnIndex = colIndex + 1;
	const currentColumn = item;
	const currentColumnConfig = currentColumn.config;
	const nextColumn = {...layoutData.items[rowColumns[nextColumnIndex]]};
	const nextColumnConfig =
		typeof nextColumn === 'object' && Object.keys(nextColumn).length
			? nextColumn.config
			: {};

	return {
		colIndex,
		currentColumn,
		currentColumnConfig,
		isLastColumn: rowColumns.indexOf(item.itemId) === rowColumns.length - 1,
		nextColumn: nextColumn ? nextColumn : {},
		nextColumnConfig: nextColumn ? nextColumnConfig : {},
		nextColumnIndex: colIndex + 1,
		rowColumns,
	};
}
