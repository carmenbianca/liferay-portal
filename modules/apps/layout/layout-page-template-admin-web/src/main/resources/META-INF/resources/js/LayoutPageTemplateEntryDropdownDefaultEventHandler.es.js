/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	DefaultEventHandler,
	ItemSelectorDialog,
	openSimpleInputModal,
} from 'frontend-js-web';
import {Config} from 'metal-state';

class LayoutPageTemplateEntryDropdownDefaultEventHandler extends DefaultEventHandler {
	deleteLayoutPageTemplateEntry(itemData) {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			this._send(itemData.deleteLayoutPageTemplateEntryURL);
		}
	}

	deleteLayoutPageTemplateEntryPreview(itemData) {
		this._send(itemData.deleteLayoutPageTemplateEntryPreviewURL);
	}

	permissionsLayoutPageTemplateEntry(itemData) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				modal: true,
			},
			dialogIframe: {
				bodyCssClass: 'dialog-with-footer',
			},
			title: Liferay.Language.get('permissions'),
			uri: itemData.permissionsLayoutPageTemplateEntryURL,
		});
	}

	renameLayoutPageTemplateEntry(itemData) {
		openSimpleInputModal({
			dialogTitle: Liferay.Language.get('rename-display-page-template'),
			formSubmitURL: itemData.updateLayoutPageTemplateEntryURL,
			idFieldName: itemData.idFieldName,
			idFieldValue: itemData.idFieldValue,
			mainFieldLabel: Liferay.Language.get('name'),
			mainFieldName: 'name',
			mainFieldPlaceholder: Liferay.Language.get('name'),
			mainFieldValue: itemData.layoutPageTemplateEntryName,
			namespace: this.namespace,
			spritemap: this.spritemap,
		});
	}

	updateLayoutPageTemplateEntryPreview(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			eventName: this.ns('changePreview'),
			singleSelect: true,
			title: Liferay.Language.get('page-template-thumbnail'),
			url: itemData.itemSelectorURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const itemValue = JSON.parse(selectedItem.value);

				this.one('#layoutPageTemplateEntryId').value =
					itemData.layoutPageTemplateEntryId;
				this.one('#fileEntryId').value = itemValue.fileEntryId;

				submitForm(this.one('#layoutPageTemplateEntryPreviewFm'));
			}
		});

		itemSelectorDialog.open();
	}

	_send(url) {
		submitForm(document.hrefFm, url);
	}
}

LayoutPageTemplateEntryDropdownDefaultEventHandler.STATE = {
	spritemap: Config.string(),
};

export default LayoutPageTemplateEntryDropdownDefaultEventHandler;
