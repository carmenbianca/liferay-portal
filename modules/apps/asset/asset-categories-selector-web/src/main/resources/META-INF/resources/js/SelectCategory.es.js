/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import {Treeview} from 'frontend-js-components-web';
import React, {useCallback, useRef, useState} from 'react';

function visit(nodes, callback) {
	nodes.forEach(node => {
		callback(node);

		if (node.children) {
			visit(node.children, callback);
		}
	});
}

function SelectCategory({
	itemSelectorSaveEvent,
	multiSelection,
	namespace,
	nodes,
}) {
	const [filterQuery, setFilterQuery] = useState('');

	const selectedNodesRef = useRef(null);

	const handleQueryChange = useCallback(event => {
		const value = event.target.value;

		setFilterQuery(value);
	}, []);

	const handleSelectionChange = selectedNodes => {
		const data = {};

		// Mark newly selected nodes as selected.
		visit(nodes, node => {
			if (selectedNodes.has(node.id)) {
				data[node.id] = {
					categoryId: node.vocabulary ? 0 : node.id,
					nodePath: node.nodePath,
					value: node.name,
					vocabularyId: node.vocabulary ? node.id : 0,
				};
			}
		});

		// Mark unselected nodes as unchecked.
		if (selectedNodesRef.current) {
			Object.entries(selectedNodesRef.current).forEach(([id, node]) => {
				if (!selectedNodes.has(id)) {
					data[id] = {
						...node,
						unchecked: true,
					};
				}
			});
		}

		selectedNodesRef.current = data;

		Liferay.Util.getOpener().Liferay.fire(itemSelectorSaveEvent, {data});
	};

	const initialSelectedNodeIds = [];

	visit(nodes, node => {
		if (node.selected) {
			initialSelectedNodeIds.push(node.id);
		}
	});

	return (
		<div className="select-category">
			<form className="select-category-filter" role="search">
				<div className="container-fluid-1280">
					<div className="input-group">
						<div className="input-group-item">
							<input
								className="form-control input-group-inset input-group-inset-after"
								onChange={handleQueryChange}
								placeholder={Liferay.Language.get('search')}
								type="text"
							/>

							<div className="input-group-inset-item input-group-inset-item-after pr-3">
								<ClayIcon symbol="search" />
							</div>
						</div>
					</div>
				</div>
			</form>

			<form name={`${namespace}selectCategoryFm`}>
				<fieldset className="container-fluid-1280">
					<div
						className="category-tree"
						id={`${namespace}categoryContainer`}
					>
						<Treeview
							filterQuery={filterQuery}
							initialSelectedNodeIds={initialSelectedNodeIds}
							multiSelection={multiSelection}
							NodeComponent={Treeview.Card}
							nodes={nodes}
							onSelectedNodesChange={handleSelectionChange}
						/>
					</div>
				</fieldset>
			</form>
		</div>
	);
}

export default SelectCategory;
