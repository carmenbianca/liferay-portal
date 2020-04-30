/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ItemSelectorDialog, PortletBase} from 'frontend-js-web';

class SharedAssets extends PortletBase {
	constructor(config, ...args) {
		super(config, ...args);

		this._selectAssetTypeURL = config.selectAssetTypeURL;
		this._viewAssetTypeURL = config.viewAssetTypeURL;
	}

	attached() {
		Liferay.on('sharing:changed', () =>
			Liferay.Portlet.refresh('#p_p_id' + this.namespace)
		);
	}

	handleFilterItemClicked(event) {
		const itemData = event.data.item.data;
		const namespace = this.namespace;
		const viewAssetTypeURL = this._viewAssetTypeURL;

		if (itemData.action === 'openAssetTypesSelector') {
			const itemSelectorDialog = new ItemSelectorDialog({
				eventName: namespace + 'selectAssetType',
				singleSelect: true,
				title: Liferay.Language.get('select-asset-type'),
				url: this._selectAssetTypeURL,
			});

			itemSelectorDialog.open();

			itemSelectorDialog.on('selectedItemChange', event => {
				const selectedItem = event.selectedItem;

				if (selectedItem) {
					let uri = viewAssetTypeURL;

					uri = Liferay.Util.addParams(
						namespace + 'className=' + selectedItem.value,
						uri
					);

					location.href = uri;
				}
			});
		}
	}
}

export default SharedAssets;
