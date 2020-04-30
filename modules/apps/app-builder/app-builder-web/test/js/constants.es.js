/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const createItems = size => {
	const items = [];

	for (let i = 0; i < size; i++) {
		items.push({
			dateCreated: '2020-03-26T11:26:54.262Z',
			dateModified: '2020-03-26T11:26:54.262Z',
			id: i + 1,
			name: {
				en_US: `Item ${i + 1}`,
			},
		});
	}

	return items;
};

export const ACTIONS = [
	{
		action: () => {},
		name: 'Delete',
	},
];

export const COLUMNS = [
	{
		key: 'name',
		value: 'Name',
	},
	{
		key: 'dateCreated',
		value: 'Created Date',
	},
	{
		key: 'dateModified',
		value: 'Modified Date',
	},
];

export const EMPTY_STATE = {
	description: 'description',
	title: 'title',
};

export const ENDPOINT = '/endpoint';

export const ITEMS = {
	ONE: createItems(1),
	TWENTY: createItems(20),
};

export const RESPONSES = {
	NO_ITEMS: {
		lastPage: 1,
		page: 1,
		pageSize: 20,
		totalCount: 0,
	},
	ONE_ITEM: {
		items: ITEMS.ONE,
		lastPage: 1,
		page: 1,
		pageSize: 20,
		totalCount: ITEMS.ONE.length,
	},
	TWENTY_ONE_ITEMS: {
		items: ITEMS.TWENTY,
		lastPage: 2,
		page: 1,
		pageSize: 20,
		totalCount: ITEMS.TWENTY.length + 1,
	},
};
