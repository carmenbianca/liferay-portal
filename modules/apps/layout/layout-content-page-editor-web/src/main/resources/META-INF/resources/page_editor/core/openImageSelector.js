/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ItemSelectorDialog} from 'frontend-js-web';

import {config} from '../app/config/index';

export function openImageSelector(callback, destroyedCallback = null) {
	const itemSelectorDialog = new ItemSelectorDialog({
		eventName: `${config.portletNamespace}selectImage`,
		singleSelect: true,
		title: Liferay.Language.get('select'),
		url: config.imageSelectorURL,
	});

	itemSelectorDialog.on('selectedItemChange', event => {
		const selectedItem = event.selectedItem || {};

		const {returnType, value} = selectedItem;

		if (returnType) {
			const selectedImage = {};

			if (returnType === 'URL') {
				selectedImage.title = '';
				selectedImage.url = value;
			}
			else {
				const fileEntry = JSON.parse(value);

				selectedImage.title = fileEntry.title;
				selectedImage.url = fileEntry.url;
			}

			callback(selectedImage);
		}
		else {
			if (destroyedCallback) {
				destroyedCallback();
			}
		}
	});

	itemSelectorDialog.on('visibleChange', () => {
		if (destroyedCallback) {
			destroyedCallback();
		}
	});

	itemSelectorDialog.open();
}
