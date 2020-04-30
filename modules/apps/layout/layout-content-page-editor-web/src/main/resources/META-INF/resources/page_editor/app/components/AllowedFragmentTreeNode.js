/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayCheckbox} from '@clayui/form';
import React from 'react';

function hasSomeChildrenSelected(node) {
	return node.children.some(
		children => children.selected || hasSomeChildrenSelected(children)
	);
}

export default function AllowedFragmentTreeNode({node}) {
	return (
		<div className="lfr-treeview-label">
			<ClayCheckbox
				aria-label={node.name}
				checked={node.selected}
				indeterminate={!node.selected && hasSomeChildrenSelected(node)}
				label={node.name}
				onChange={() => {}}
				onDoubleClick={event => {
					event.stopPropagation();
				}}
			/>
		</div>
	);
}
