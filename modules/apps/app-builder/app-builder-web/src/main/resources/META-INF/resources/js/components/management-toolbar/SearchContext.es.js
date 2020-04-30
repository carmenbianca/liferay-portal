/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {createContext} from 'react';

const reducer = (state, action) => {
	switch (action.type) {
		case 'CHANGE_PAGE':
			return {
				...state,
				page: action.page,
			};
		case 'CHANGE_PAGE_SIZE':
			return {
				...state,
				page: 1,
				pageSize: action.pageSize,
			};
		case 'SEARCH':
			return {
				...state,
				keywords: action.keywords,
				page: 1,
			};
		case 'SORT':
			return {
				...state,
				sort: action.sort,
			};
		default:
			return state;
	}
};

const SearchContext = createContext();

export {reducer};
export default SearchContext;
