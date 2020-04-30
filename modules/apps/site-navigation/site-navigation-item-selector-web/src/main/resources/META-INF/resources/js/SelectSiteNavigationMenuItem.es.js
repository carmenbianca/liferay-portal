/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayButtonWithIcon} from '@clayui/button';
import {ClayInput} from '@clayui/form';
import {Treeview} from 'frontend-js-components-web';
import React, {useCallback, useState} from 'react';

const SelectSiteNavigationMenuItem = ({itemSelectorSaveEvent, nodes}) => {
	const [filterQuery, setFilterQuery] = useState('');

	const handleQueryChange = useCallback(event => {
		const value = event.target.value;

		setFilterQuery(value);
	}, []);

	const handleSelectionChange = selectedNodeIds => {
		const selectedNodeId = [...selectedNodeIds][0];

		if (selectedNodeId) {
			const {id, name} = nodes[0].children.find(
				node => node.id === selectedNodeId
			);

			const data = {
				selectSiteNavigationMenuItemId: id,
				selectSiteNavigationMenuItemName: name,
			};

			Liferay.Util.getOpener().Liferay.fire(itemSelectorSaveEvent, {
				data,
			});
		}
	};

	return (
		<div className="container-fluid-1280">
			<nav className="collapse-basic-search navbar navbar-default navbar-no-collapse">
				<ClayInput.Group className="basic-search">
					<ClayInput.GroupItem prepend>
						<ClayInput
							aria-label={Liferay.Language.get('search')}
							onChange={handleQueryChange}
							placeholder={`${Liferay.Language.get('search')}`}
							type="text"
						/>
					</ClayInput.GroupItem>

					<ClayInput.GroupItem append shrink>
						<ClayButtonWithIcon
							displayType="unstyled"
							symbol="search"
						/>
					</ClayInput.GroupItem>
				</ClayInput.Group>
			</nav>

			<Treeview
				filterQuery={filterQuery}
				NodeComponent={Treeview.Card}
				nodes={nodes}
				onSelectedNodesChange={handleSelectionChange}
			/>
		</div>
	);
};

export default SelectSiteNavigationMenuItem;
