/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayButtonWithIcon} from '@clayui/button';
import ClayDropDown, {Align} from '@clayui/drop-down';
import React, {useState} from 'react';

const {Item, ItemList} = ClayDropDown;

export default ({actions}) => {
	const [active, setActive] = useState(false);

	const DropdownButton = (
		<ClayButtonWithIcon
			className="page-link"
			displayType="unstyled"
			symbol="ellipsis-v"
		/>
	);

	if (actions.length === 0) {
		return DropdownButton;
	}

	const onSelectItem = (event, action) => {
		event.preventDefault();

		if (typeof action.action === 'function') {
			action.action();
		}

		setActive(false);
	};

	return (
		<ClayDropDown
			active={active}
			alignmentPosition={Align.RightCenter}
			className="dropdown-action"
			onActiveChange={item => setActive(item)}
			trigger={DropdownButton}
		>
			<ItemList>
				{actions.map((action, index) => (
					<Item
						key={index}
						onClick={event => onSelectItem(event, action)}
					>
						{action.name}
					</Item>
				))}
			</ItemList>
		</ClayDropDown>
	);
};
