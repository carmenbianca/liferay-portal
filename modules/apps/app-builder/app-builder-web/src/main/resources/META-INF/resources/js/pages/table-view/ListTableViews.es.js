/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';
import {Link} from 'react-router-dom';

import Button from '../../components/button/Button.es';
import ListView from '../../components/list-view/ListView.es';
import {confirmDelete} from '../../utils/client.es';
import {fromNow} from '../../utils/time.es';

const COLUMNS = [
	{
		key: 'name',
		sortable: true,
		value: Liferay.Language.get('name'),
	},
	{
		key: 'dateCreated',
		sortable: true,
		value: Liferay.Language.get('create-date'),
	},
	{
		asc: false,
		key: 'dateModified',
		sortable: true,
		value: Liferay.Language.get('modified-date'),
	},
];

export default ({
	history,
	match: {
		params: {dataDefinitionId},
		url,
	},
}) => {
	return (
		<ListView
			actions={[
				{
					action: item =>
						Promise.resolve(history.push(`${url}/${item.id}`)),
					name: Liferay.Language.get('edit'),
				},
				{
					action: confirmDelete(
						'/o/data-engine/v2.0/data-list-views/'
					),
					name: Liferay.Language.get('delete'),
				},
			]}
			addButton={() => (
				<Button
					className="nav-btn nav-btn-monospaced"
					href={`${url}/add`}
					symbol="plus"
					tooltip={Liferay.Language.get('new-table-view')}
				/>
			)}
			columns={COLUMNS}
			emptyState={{
				button: () => (
					<Button displayType="secondary" href={`${url}/add`}>
						{Liferay.Language.get('new-table-view')}
					</Button>
				),
				description: Liferay.Language.get(
					'create-one-or-more-tables-to-display-the-data-held-in-your-data-object'
				),
				title: Liferay.Language.get('there-are-no-table-views-yet'),
			}}
			endpoint={`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-list-views`}
		>
			{item => ({
				...item,
				dateCreated: fromNow(item.dateCreated),
				dateModified: fromNow(item.dateModified),
				name: <Link to={`${url}/${item.id}`}>{item.name.en_US}</Link>,
			})}
		</ListView>
	);
};
