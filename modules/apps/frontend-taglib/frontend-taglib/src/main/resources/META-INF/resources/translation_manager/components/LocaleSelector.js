/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayButtonWithIcon} from '@clayui/button';
import ClayDropDown, {Align} from '@clayui/drop-down';
import React, {useState} from 'react';

const DropDownWithState = ({children}) => {
	const [isDropdownOpen, setIsDropdownOpen] = useState(false);

	return (
		<ClayDropDown
			active={isDropdownOpen}
			alignmentPosition={Align.BottomCenter}
			onActiveChange={isActive => setIsDropdownOpen(isActive)}
			trigger={
				<ClayButtonWithIcon
					borderless
					displayType="secondary"
					small
					symbol="plus"
				/>
			}
		>
			{children({setActive: setIsDropdownOpen})}
		</ClayDropDown>
	);
};
export default function LocaleSelector({locales, onItemClick}) {
	return (
		<DropDownWithState>
			{({setActive}) => (
				<ClayDropDown.ItemList>
					{locales.map(locale => (
						<ClayDropDown.Item
							id={locale.id}
							key={locale.id}
							onClick={() => {
								onItemClick(locale);
								setActive(false);
							}}
							symbolRight={locale.icon}
						>
							{locale.label}
						</ClayDropDown.Item>
					))}
				</ClayDropDown.ItemList>
			)}
		</DropDownWithState>
	);
}
