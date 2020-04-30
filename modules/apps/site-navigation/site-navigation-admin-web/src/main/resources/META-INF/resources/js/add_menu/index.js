/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import ClayIcon from '@clayui/icon';
import React, {useCallback, useState} from 'react';

function AddMenu({dropdownItems, portletId}) {
	const [active, setActive] = useState(false);

	const handleItemClick = useCallback(
		event => {
			event.currentTarget = event.target.element || event.target;

			const uri = event.data
				? event.data.item.href
				: event.target.dataset.href;

			Liferay.Util.openInDialog(event.nativeEvent || event, {
				dialog: {
					destroyOnHide: true,
				},
				dialogIframe: {
					bodyCssClass: 'dialog-with-footer',
				},
				id: `_${portletId}_addMenuItem`,
				title: event.target.title || event.target.innerText,
				uri,
			});
		},
		[portletId]
	);

	const addMenuDefaultEventHandlerId = `_${portletId}_AddMenuDefaultEventHandler`;

	if (!Liferay.component(addMenuDefaultEventHandlerId)) {
		class AddMenuDefaultEventHandler {
			handleItemClicked(event) {
				handleItemClick(event);
			}
		}

		Liferay.component(
			addMenuDefaultEventHandlerId,
			new AddMenuDefaultEventHandler(),
			{
				destroyOnNavigate: true,
			}
		);
	}

	return (
		<ClayDropDown
			active={active}
			onActiveChange={newVal => setActive(newVal)}
			trigger={
				<ClayButton
					className={
						'btn btn-primary dropdown-toggle nav-btn nav-btn-monospaced'
					}
				>
					<ClayIcon symbol="plus" />
				</ClayButton>
			}
		>
			<ClayDropDown.ItemList>
				{dropdownItems.map(({href, label}) => (
					<ClayDropDown.Item
						data-href={href}
						key={href}
						onClick={handleItemClick}
					>
						{label}
					</ClayDropDown.Item>
				))}
			</ClayDropDown.ItemList>
		</ClayDropDown>
	);
}

export default AddMenu;
