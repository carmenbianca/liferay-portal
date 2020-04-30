/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ItemSelectorDialog} from 'frontend-js-web';

export function openInfoItemSelector(
	callback,
	eventName,
	itemSelectorURL,
	destroyedCallback = null
) {
	const itemSelectorDialog = new ItemSelectorDialog({
		eventName,
		singleSelect: true,
		title: Liferay.Language.get('select'),
		url: itemSelectorURL,
	});

	itemSelectorDialog.on('selectedItemChange', event => {
		const selectedItem = event.selectedItem;

		if (selectedItem && selectedItem.value) {
			const infoItem = {
				...JSON.parse(selectedItem.value),
				type: selectedItem.returnType,
			};

			callback(infoItem);
		}
	});

	itemSelectorDialog.on('visibleChange', event => {
		if (
			!event.newVal &&
			destroyedCallback &&
			typeof destroyedCallback === 'function'
		) {
			destroyedCallback();
		}
	});

	itemSelectorDialog.open();
}
