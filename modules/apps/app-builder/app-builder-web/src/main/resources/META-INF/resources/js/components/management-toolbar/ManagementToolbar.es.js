/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayManagementToolbar from '@clayui/management-toolbar';
import React, {useContext, useState} from 'react';

import ManagementToolbarLeft from './ManagementToolbarLeft.es';
import ManagementToolbarRight from './ManagementToolbarRight.es';
import ManagementToolbarSearch from './ManagementToolbarSearch';
import SearchContext from './SearchContext.es';

export default ({addButton, columns, totalCount}) => {
	const [{keywords}, dispatch] = useContext(SearchContext);
	const [showMobile, setShowMobile] = useState(false);
	const disabled = keywords === '' && totalCount === 0;

	return (
		<ClayManagementToolbar>
			<ManagementToolbarLeft columns={columns} disabled={disabled} />

			<ManagementToolbarSearch
				disabled={disabled}
				onSubmit={searchText =>
					dispatch({keywords: searchText, type: 'SEARCH'})
				}
				searchText={keywords}
				setShowMobile={setShowMobile}
				showMobile={showMobile}
			/>

			<ManagementToolbarRight
				addButton={addButton}
				setShowMobile={setShowMobile}
			/>
		</ClayManagementToolbar>
	);
};
