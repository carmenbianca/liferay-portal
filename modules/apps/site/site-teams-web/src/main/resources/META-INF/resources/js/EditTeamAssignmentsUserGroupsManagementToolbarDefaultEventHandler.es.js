/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';
import dom from 'metal-dom';

class EditTeamAssignmentsUserGroupsManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	selectUserGroup(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			eventName: this.ns('selectUserGroup'),
			title: itemData.title,
			url: itemData.selectUserGroupURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const addTeamUserGroupsFm = this.one('#addTeamUserGroupsFm');

				selectedItem.forEach(item => {
					dom.append(addTeamUserGroupsFm, item);
				});

				submitForm(addTeamUserGroupsFm);
			}
		});

		itemSelectorDialog.open();
	}

	deleteUserGroups() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}
}

export default EditTeamAssignmentsUserGroupsManagementToolbarDefaultEventHandler;
