/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';
import dom from 'metal-dom';

class EditTeamAssignmentsUsersManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	selectUser(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			eventName: this.ns('selectUser'),
			title: itemData.title,
			url: itemData.selectUserURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const addTeamUsersFm = this.one('#addTeamUsersFm');

				selectedItem.forEach(item => {
					dom.append(addTeamUsersFm, item);
				});

				submitForm(addTeamUsersFm);
			}
		});

		itemSelectorDialog.open();
	}

	deleteUsers() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}
}

export default EditTeamAssignmentsUsersManagementToolbarDefaultEventHandler;
