/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayCheckbox} from '@clayui/form';
import ClayTable from '@clayui/table';
import React from 'react';

import DropDown from './DropDown.es';

const {Body, Cell, Head, Row} = ClayTable;

const Table = ({
	actions,
	align = 'left',
	checkable,
	columns,
	forwardRef,
	items,
}) => {
	return (
		<div ref={forwardRef}>
			<ClayTable hover={false}>
				<Head>
					<Row>
						{checkable && <Cell headingCell></Cell>}
						{columns.map((column, index) => (
							<Cell
								align={index === 0 ? 'left' : align}
								className={
									index > 0 && 'table-cell-expand-smaller'
								}
								expanded={index === 0}
								headingCell
								key={index}
							>
								{column.value}
							</Cell>
						))}
						{actions && <Cell headingCell></Cell>}
					</Row>
				</Head>
				<Body>
					{items.map(item => (
						<Row key={item.id}>
							{checkable && (
								<Cell>
									<ClayCheckbox
										checked={false}
										disabled={false}
										indeterminate={false}
									/>
								</Cell>
							)}
							{columns.map((column, index) => (
								<Cell
									align={index === 0 ? 'left' : align}
									className={
										index > 0 && 'table-cell-expand-smaller'
									}
									expanded={index === 0}
									headingTitle={index === 0}
									key={index}
								>
									{item[column.key]}
								</Cell>
							))}
							{actions && (
								<Cell>
									<DropDown actions={actions} item={item} />
								</Cell>
							)}
						</Row>
					))}
				</Body>
			</ClayTable>
		</div>
	);
};

export default React.forwardRef((props, ref) => (
	<Table {...props} forwardRef={ref} />
));
