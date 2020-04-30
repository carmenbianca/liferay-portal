/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useResource} from '@clayui/data-provider';
import React, {useCallback, useEffect, useState} from 'react';
import {withRouter} from 'react-router-dom';

import useQuery from '../../hooks/useQuery.es';
import {getURL} from '../../utils/client.es';
import ManagementToolbar from '../management-toolbar/ManagementToolbar.es';
import ManagementToolbarResultsBar from '../management-toolbar/ManagementToolbarResultsBar.es';
import SearchContext, {reducer} from '../management-toolbar/SearchContext.es';
import TableWithPagination from '../table/TableWithPagination.es';

export default withRouter(
	({
		actions,
		addButton,
		children,
		columns,
		emptyState,
		endpoint,
		history,
		queryParams,
	}) => {
		const [query, setQuery] = useQuery(history, {
			keywords: '',
			page: 1,
			pageSize: 20,
			sort: '',
			...queryParams,
		});

		const dispatch = useCallback(
			action => setQuery(reducer(query, action)),
			[query, setQuery]
		);

		const {refetch, resource} = useResource({
			fetchDelay: 0,
			fetchOptions: {
				credentials: 'same-origin',
				method: 'GET',
			},
			link: getURL(endpoint),
			onNetworkStatusChange: status => setLoading(status < 4),
			variables: {...query},
		});

		let items = [];
		let totalCount = 0;
		let totalPages = 1;

		if (resource) {
			({items = [], totalCount, lastPage: totalPages} = resource);
		}

		useEffect(() => {
			if (query.page > totalPages) {
				dispatch({page: totalPages, type: 'CHANGE_PAGE'});
			}
		}, [dispatch, query.page, totalPages]);

		let refetchOnActions;

		if (actions && actions.length > 0) {
			refetchOnActions = actions.map(action => {
				if (!action.action) {
					return action;
				}

				return {
					...action,
					action: item => {
						action.action(item).then(isRefetch => {
							if (!isRefetch) {
								return;
							}

							refetch();
						});
					},
				};
			});
		}

		const [isLoading, setLoading] = useState(true);

		return (
			<SearchContext.Provider value={[query, dispatch]}>
				<ManagementToolbar
					addButton={addButton}
					columns={columns}
					totalCount={totalCount}
				/>

				<ManagementToolbarResultsBar
					isLoading={isLoading}
					totalCount={totalCount}
				/>

				<TableWithPagination
					actions={refetchOnActions}
					columns={columns}
					emptyState={emptyState}
					isEmpty={totalCount === 0}
					isLoading={isLoading}
					items={items.map((item, index) => children(item, index))}
					keywords={query.keywords}
					totalCount={totalCount}
				/>
			</SearchContext.Provider>
		);
	}
);
