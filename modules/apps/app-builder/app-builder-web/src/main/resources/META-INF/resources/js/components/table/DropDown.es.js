/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayDropDown, {Align} from '@clayui/drop-down';
import ClayIcon from '@clayui/icon';
import React, {useState} from 'react';

import Button from '../button/Button.es';
import DropDownAction from './DropDownAction.es';

const {ItemList} = ClayDropDown;

export default ({actions, item}) => {
	const [active, setActive] = useState(false);

	const DropdownButton = (
		<Button className="page-link" displayType="unstyled">
			<ClayIcon symbol="ellipsis-v" />
		</Button>
	);

	actions = actions.filter(action =>
		action.show ? action.show(item) : true
	);

	if (actions.length === 0) {
		return DropdownButton;
	}

	return (
		<ClayDropDown
			active={active}
			alignmentPosition={Align.RightCenter}
			className="dropdown-action"
			onActiveChange={newVal => setActive(newVal)}
			trigger={DropdownButton}
		>
			<ItemList>
				{actions.map((action, index) => (
					<DropDownAction
						action={action}
						item={item}
						key={index}
						setActive={setActive}
					/>
				))}
			</ItemList>
		</ClayDropDown>
	);
};
