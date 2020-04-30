/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayRadio, ClayRadioGroup} from '@clayui/form';
import ClayTable from '@clayui/table';
import classNames from 'classnames';
import React, {useContext} from 'react';

import {withLoading} from '../../components/loading/Loading.es';
import {withEmpty} from '../../components/table/EmptyState.es';
import {fromNow} from '../../utils/time.es';
import EditAppContext, {
	UPDATE_DATA_LAYOUT_ID,
	UPDATE_DATA_LIST_VIEW_ID,
} from './EditAppContext.es';

const {Body, Cell, Head, Row} = ClayTable;

const ListItems = ({itemType, items}) => {
	const {
		dispatch,
		state: {
			app: {dataLayoutId, dataListViewId},
		},
	} = useContext(EditAppContext);

	const itemId = itemType === 'DATA_LAYOUT' ? dataLayoutId : dataListViewId;

	const onItemIdChange = id => {
		const type =
			itemType === 'DATA_LAYOUT'
				? UPDATE_DATA_LAYOUT_ID
				: UPDATE_DATA_LIST_VIEW_ID;

		dispatch({
			id,
			type,
		});
	};

	return (
		<table className="table table-autofit table-heading-nowrap table-hover table-nowrap table-responsive">
			<Head>
				<Row>
					<Cell expanded={true} headingCell>
						{Liferay.Language.get('name')}
					</Cell>
					<Cell headingCell>
						{Liferay.Language.get('create-date')}
					</Cell>
					<Cell headingCell>
						{Liferay.Language.get('modified-date')}
					</Cell>
					<Cell headingCell></Cell>
				</Row>
			</Head>
			<Body>
				{items.map(
					(
						{
							dateCreated,
							dateModified,
							id,
							name: {en_US: itemName},
						},
						index
					) => {
						return (
							<Row
								className={classNames('selectable-row', {
									'selectable-active': id === itemId,
								})}
								key={index}
								onClick={() => onItemIdChange(id)}
							>
								<Cell align="left">{itemName}</Cell>
								<Cell>{fromNow(dateCreated)}</Cell>
								<Cell>{fromNow(dateModified)}</Cell>
								<Cell align={'right'}>
									<ClayRadioGroup
										inline
										onSelectedValueChange={() =>
											onItemIdChange(id)
										}
										selectedValue={itemId}
									>
										<ClayRadio value={id} />
									</ClayRadioGroup>
								</Cell>
							</Row>
						);
					}
				)}
			</Body>
		</table>
	);
};

export default withLoading(withEmpty(ListItems));
