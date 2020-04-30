/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

export default function TreeviewLabel({node}) {
	const inputId = `${node.id}-treeview-label-input`;

	return (
		<div className="lfr-treeview-label">
			<input
				checked={node.selected}
				className="sr-only"
				id={inputId}
				onChange={() => {
					// Let NodeListItem handle checked state.
				}}
				type="checkbox"
			/>

			<label
				className={
					node.selected ? 'font-weight-bold' : 'font-weight-normal'
				}
				htmlFor={inputId}
				onClick={event => event.preventDefault()}
			>
				{node.name}
			</label>
		</div>
	);
}
