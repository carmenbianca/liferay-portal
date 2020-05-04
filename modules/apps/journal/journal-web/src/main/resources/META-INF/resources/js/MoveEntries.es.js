/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ItemSelectorDialog, PortletBase} from 'frontend-js-web';
import {Config} from 'metal-state';

/**
 * @class MoveEntries
 * It adds a listener to a #selectFolderButton DOM element
 * and allows selecting a directory with itemSelector
 * @review
 */
class MoveEntries extends PortletBase {
	/**
	 * @inheritdoc
	 * @review
	 */
	created() {
		const selectFolderButton = document.getElementById(
			this.ns('selectFolderButton')
		);

		if (selectFolderButton) {
			this._handleSelectFolderButtonClick = this._handleSelectFolderButtonClick.bind(
				this
			);

			selectFolderButton.addEventListener(
				'click',
				this._handleSelectFolderButtonClick
			);
		}
	}

	/**
	 * @inheritdoc
	 * @review
	 */
	disposed() {
		const selectFolderButton = document.getElementById(
			this.ns('selectFolderButton')
		);

		if (selectFolderButton) {
			selectFolderButton.removeEventListener(
				'click',
				this._handleSelectFolderButtonClick
			);
		}
	}

	/**
	 * @private
	 * @review
	 */
	_handleSelectFolderButtonClick() {
		const itemSelectorDialog = new ItemSelectorDialog({
			eventName: this.ns('selectFolder'),
			singleSelect: true,
			title: Liferay.Language.get('select-folder'),
			url: this.selectFolderURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				var folderData = {
					idString: 'newFolderId',
					idValue: selectedItem.folderId,
					nameString: 'folderName',
					nameValue: selectedItem.folderName,
				};

				Liferay.Util.selectFolder(
					folderData,
					this.namespace || this.portletNamespace
				);
			}
		});

		itemSelectorDialog.open();
	}
}

/**
 * @memberof MoveEntries
 * @review
 * @static
 */
MoveEntries.STATE = {
	/**
	 * @default undefined
	 * @memberof MoveEntries
	 * @required
	 * @review
	 * @type {string}
	 */
	selectFolderURL: Config.string().required(),
};

export default MoveEntries;
