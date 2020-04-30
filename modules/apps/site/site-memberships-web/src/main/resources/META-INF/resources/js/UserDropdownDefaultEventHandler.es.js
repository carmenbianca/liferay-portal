/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';
import dom from 'metal-dom';

class UserDropdownDefaultEventHandler extends DefaultEventHandler {
	deleteGroupUsers(itemData) {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(document.hrefFm, itemData.deleteGroupUsersURL);
		}
	}

	assignRoles(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			buttonAddLabel: Liferay.Language.get('done'),
			eventName: this.ns('selectUsersRoles'),
			title: Liferay.Language.get('assign-roles'),
			url: itemData.assignRolesURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const editUserGroupRoleFm = this.one('#editUserGroupRoleFm');

				selectedItem.forEach(item => {
					dom.append(editUserGroupRoleFm, item);
				});

				submitForm(editUserGroupRoleFm, itemData.editUserGroupRoleURL);
			}
		});

		itemSelectorDialog.open();
	}
}

export default UserDropdownDefaultEventHandler;
