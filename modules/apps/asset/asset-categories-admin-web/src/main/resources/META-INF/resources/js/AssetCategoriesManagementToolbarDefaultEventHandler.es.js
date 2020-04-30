/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';

class AssetCategoriesManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteSelectedCategories() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}

	selectCategory(itemData) {
		const namespace = this.namespace;

		const itemSelectorDialog = new ItemSelectorDialog({
			eventName: this.ns('selectCategory'),
			singleSelect: true,
			title: Liferay.Language.get('select-category'),
			url: itemData.categoriesSelectorURL,
		});

		itemSelectorDialog.open();

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			const category = selectedItem
				? selectedItem[Object.keys(selectedItem)[0]]
				: null;

			if (category) {
				location.href = Liferay.Util.addParams(
					namespace + 'categoryId=' + category.categoryId,
					itemData.viewCategoriesURL
				);
			}
		});
	}
}

export default AssetCategoriesManagementToolbarDefaultEventHandler;
