/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React from 'react';

import NodeListItem from './NodeListItem';

export default function NodeList({
	NodeComponent,
	nodes,
	onBlur,
	onFocus,
	role = 'group',
	tabIndex = -1,
}) {
	const rootNodeId = nodes[0] && nodes[0].id;

	if (!rootNodeId) {
		// All nodes have been filtered.
		return null;
	}

	return (
		<div
			className="lfr-treeview-node-list"
			onBlur={() => {
				if (onBlur) {
					onBlur();
				}
			}}
			onFocus={event => {
				if (onFocus) {
					onFocus(event);
				}
			}}
			role={role}
			tabIndex={tabIndex}
		>
			{nodes.map(node => (
				<NodeListItem
					key={node.id}
					node={node}
					NodeComponent={NodeComponent}
				/>
			))}
		</div>
	);
}

NodeList.propTypes = {
	NodeComponent: PropTypes.func.isRequired,
	nodes: PropTypes.arrayOf(
		PropTypes.shape({
			children: PropTypes.array,
			id: PropTypes.string.isRequired,
			name: PropTypes.string.isRequired,
		})
	).isRequired,
	onBlur: PropTypes.func,
	onFocus: PropTypes.func,
	tabIndex: PropTypes.number,
};
