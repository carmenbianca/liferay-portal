/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {SearchInput} from 'data-engine-taglib';
import React, {useState} from 'react';

import {useRequest} from '../../hooks/index.es';
import ListItems from './ListItems.es';

export default ({endpoint, title, ...restProps}) => {
	const [searchText, setSearchText] = useState('');

	const {
		response: {items = []},
		isLoading,
	} = useRequest(endpoint);

	const filteredItems = items.filter(item =>
		new RegExp(searchText, 'ig').test(item.name.en_US)
	);

	return (
		<>
			<div className="autofit-row mb-4 pl-4 pr-4">
				<div className="autofit-col-expand">
					<h2>{title}</h2>
				</div>
			</div>

			<div className="autofit-row mb-4 pl-4 pr-4">
				<div className="autofit-col-expand">
					<SearchInput
						onChange={searchText => setSearchText(searchText)}
					/>
				</div>
			</div>

			<div className="autofit-row pl-4 pr-4 scrollable-container">
				<div className="autofit-col-expand">
					<ListItems
						isEmpty={filteredItems.length === 0}
						isLoading={isLoading}
						items={filteredItems}
						keywords={searchText}
						{...restProps}
					/>
				</div>
			</div>
		</>
	);
};
