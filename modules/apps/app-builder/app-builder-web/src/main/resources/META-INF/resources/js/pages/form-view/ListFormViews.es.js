/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useContext} from 'react';

import {AppContext} from '../../AppContext.es';
import Button from '../../components/button/Button.es';
import ListView from '../../components/list-view/ListView.es';
import {confirmDelete} from '../../utils/client.es';
import {fromNow} from '../../utils/time.es';

export default ({
	match: {
		params: {dataDefinitionId},
	},
}) => {
	const {basePortletURL} = useContext(AppContext);

	const getItemURL = item =>
		Liferay.Util.PortletURL.createRenderURL(basePortletURL, {
			dataDefinitionId,
			dataLayoutId: item.id,
			mvcRenderCommandName: '/edit_form_view',
		});

	const handleEditItem = item => {
		const itemURL = getItemURL(item);

		Liferay.Util.navigate(itemURL);
	};

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

	const addURL = Liferay.Util.PortletURL.createRenderURL(basePortletURL, {
		dataDefinitionId,
		mvcRenderCommandName: '/edit_form_view',
	});

	return (
		<ListView
			actions={[
				{
					action: item => Promise.resolve(handleEditItem(item)),
					name: Liferay.Language.get('edit'),
				},
				{
					action: confirmDelete('/o/data-engine/v2.0/data-layouts/'),
					name: Liferay.Language.get('delete'),
				},
			]}
			addButton={() => (
				<Button
					className="nav-btn nav-btn-monospaced"
					onClick={() => Liferay.Util.navigate(addURL)}
					symbol="plus"
					tooltip={Liferay.Language.get('new-form-view')}
				/>
			)}
			columns={COLUMNS}
			emptyState={{
				button: () => (
					<Button
						displayType="secondary"
						onClick={() => Liferay.Util.navigate(addURL)}
					>
						{Liferay.Language.get('new-form-view')}
					</Button>
				),
				description: Liferay.Language.get(
					'create-one-or-more-forms-to-display-the-data-held-in-your-data-object'
				),
				title: Liferay.Language.get('there-are-no-form-views-yet'),
			}}
			endpoint={`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-layouts`}
		>
			{item => ({
				dataDefinitionId,
				dateCreated: fromNow(item.dateCreated),
				dateModified: fromNow(item.dateModified),
				id: item.id,
				name: <a href={getItemURL(item)}>{item.name.en_US}</a>,
			})}
		</ListView>
	);
};
