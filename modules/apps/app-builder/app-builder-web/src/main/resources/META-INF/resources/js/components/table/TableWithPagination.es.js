/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayPaginationBarWithBasicItems} from '@clayui/pagination-bar';
import React, {useContext} from 'react';

import {withLoading} from '../loading/Loading.es';
import SearchContext from '../management-toolbar/SearchContext.es';
import {withEmpty} from './EmptyState.es';
import Table from './Table.es';

const TableWithPagination = ({actions, columns, items, totalCount}) => {
	const [{page, pageSize}, dispatch] = useContext(SearchContext);
	const deltas = [5, 10, 20, 30, 50, 75].map(size => ({label: size}));

	return (
		<div className="container-fluid container-fluid-max-xl">
			<Table actions={actions} columns={columns} items={items} />

			{totalCount > 5 && (
				<div className="taglib-search-iterator-page-iterator-bottom">
					<ClayPaginationBarWithBasicItems
						activeDelta={pageSize}
						activePage={page}
						deltas={deltas}
						ellipsisBuffer={3}
						onDeltaChange={pageSize =>
							dispatch({pageSize, type: 'CHANGE_PAGE_SIZE'})
						}
						onPageChange={page =>
							dispatch({page, type: 'CHANGE_PAGE'})
						}
						totalItems={totalCount}
					/>
				</div>
			)}
		</div>
	);
};

export default withLoading(withEmpty(TableWithPagination));
