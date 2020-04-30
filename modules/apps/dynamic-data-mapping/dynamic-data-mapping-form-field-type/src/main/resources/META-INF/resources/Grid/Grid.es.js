/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import './GridRegister.soy';

import {ClayInput, ClayRadio} from '@clayui/form';
import ClayTable from '@clayui/table';
import React, {useState} from 'react';

import {FieldBaseProxy} from '../FieldBase/ReactFieldBase.es';
import getConnectedReactComponentAdapter from '../util/ReactComponentAdapter.es';
import {connectStore} from '../util/connectStore.es';
import templates from './GridAdapter.soy';

const TableHead = ({columns}) => (
	<ClayTable.Head>
		<ClayTable.Row>
			<ClayTable.Cell headingCell />
			{columns.map((column, colIndex) => {
				if (column.value) {
					return (
						<ClayTable.Cell
							headingCell
							key={`column-${column.value}-${colIndex}`}
						>
							{column.label}
						</ClayTable.Cell>
					);
				}
			})}
		</ClayTable.Row>
	</ClayTable.Head>
);

const TableBodyColumns = ({
	columns,
	disabled,
	onBlur,
	onChange,
	onFocus,
	row,
	rowIndex,
	value,
}) =>
	columns.map((column, colIndex) => {
		if (column.value) {
			return (
				<ClayTable.Cell key={`cell-${column.value}-${colIndex}`}>
					<ClayRadio
						aria-label={`grid_${rowIndex}_${colIndex}`}
						checked={column.value === value[row.value]}
						className="form-builder-grid-field"
						disabled={disabled}
						name={row.value}
						onBlur={onBlur}
						onChange={onChange}
						onFocus={onFocus}
						value={column.value}
					/>
				</ClayTable.Cell>
			);
		}
	});

const Grid = ({
	columns = [{label: 'col1', value: 'fieldId'}],
	disabled,
	name,
	onBlur = () => {},
	onChange = () => {},
	onFocus = () => {},
	rows = [{label: 'row', value: 'jehf'}],
	value,
	...otherProps
}) => (
	<div className="table-responsive" {...otherProps}>
		{!disabled &&
			rows.map((row, rowIndex) => {
				const inputValue = value[row.value]
					? `${row.value};${value[row.value]}`
					: '';

				return (
					<ClayInput
						aria-label="grid_hidden"
						key={`row-${row.value}-${rowIndex}`}
						name={name}
						type="hidden"
						value={inputValue}
					/>
				);
			})}

		<ClayTable striped>
			<TableHead columns={columns} />

			<ClayTable.Body>
				{rows.map((row, rowIndex) => {
					if (row.value) {
						return (
							<ClayTable.Row
								key={`row-${row.value}-${rowIndex}`}
								name={row.value}
							>
								<ClayTable.Cell>{row.label}</ClayTable.Cell>

								<TableBodyColumns
									columns={columns}
									disabled={disabled}
									onBlur={onBlur}
									onChange={onChange}
									onFocus={onFocus}
									row={row}
									rowIndex={rowIndex}
									value={value}
								/>
							</ClayTable.Row>
						);
					}

					return null;
				})}
			</ClayTable.Body>
		</ClayTable>
	</div>
);

const GridProxy = connectStore(
	({columns, emit, name, readOnly, rows, value = {}, ...otherProps}) => {
		const [state, setState] = useState(value);

		return (
			<FieldBaseProxy name={name} readOnly={readOnly} {...otherProps}>
				<Grid
					columns={columns}
					disabled={readOnly}
					name={name}
					onBlur={event =>
						emit('fieldBlurred', event, event.target.value)
					}
					onChange={event => {
						const {target} = event;
						const value = {
							[target.name]: target.value,
						};

						const newState = {...state, ...value};

						setState(newState);

						emit('fieldEdited', event, newState);
					}}
					onFocus={event =>
						emit('fieldFocused', event, event.target.value)
					}
					rows={rows}
					value={state}
				/>
			</FieldBaseProxy>
		);
	}
);

const ReactGridAdapter = getConnectedReactComponentAdapter(
	GridProxy,
	templates
);

export {ReactGridAdapter};

export default ReactGridAdapter;
