/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';

class FragmentCollectionResourcesManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	addFragmentCollectionResource(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			eventName: this.ns('uploadFragmentCollectionResource'),
			singleSelect: true,
			title: Liferay.Language.get('upload-fragment-collection-resource'),
			url: itemData.itemSelectorURL,
		});

		itemSelectorDialog.open();

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const itemValue = JSON.parse(selectedItem.value);

				this.one('#fileEntryId').value = itemValue.fileEntryId;

				submitForm(this.one('#fragmentCollectionResourceFm'));
			}
		});
	}

	deleteSelectedFragmentCollectionResources(itemData) {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(
				this.one('#fm'),
				itemData.deleteFragmentCollectionResourcesURL
			);
		}
	}
}

export default FragmentCollectionResourcesManagementToolbarDefaultEventHandler;
