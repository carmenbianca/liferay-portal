/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';
import dom from 'metal-dom';

class UserGroupsManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteSelectedUserGroups() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}

	removeUserGroupRole(itemData) {
		if (confirm(itemData.message)) {
			submitForm(this.one('#fm'), itemData.removeUserGroupRoleURL);
		}
	}

	selectRoles(itemData) {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					destroyOnHide: true,
					modal: true,
				},
				eventName: this.ns('selectRole'),
				title: Liferay.Language.get('select-role'),
				uri: itemData.selectRolesURL,
			},
			event => {
				location.href = Liferay.Util.addParams(
					`${this.ns('roleId')}=${event.id}`,
					itemData.viewRoleURL
				);
			}
		);
	}

	selectRole(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			buttonAddLabel: Liferay.Language.get('done'),
			eventName: this.ns('selectRole'),
			title: Liferay.Language.get('assign-roles'),
			url: itemData.selectRoleURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const fm = this.one('#fm');

				selectedItem.forEach(item => {
					dom.append(fm, item);
				});

				submitForm(fm, itemData.editUserGroupsRolesURL);
			}
		});

		itemSelectorDialog.open();
	}

	selectUserGroups(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			buttonAddLabel: Liferay.Language.get('done'),
			eventName: this.ns('selectUserGroups'),
			title: Liferay.Util.sub(
				Liferay.Language.get('assign-user-groups-to-this-x'),
				itemData.groupTypeLabel
			),
			url: itemData.selectUserGroupsURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const addGroupUserGroupsFm = this.one('#addGroupUserGroupsFm');

				selectedItem.forEach(item => {
					dom.append(addGroupUserGroupsFm, item);
				});

				submitForm(addGroupUserGroupsFm);
			}
		});

		itemSelectorDialog.open();
	}
}

export default UserGroupsManagementToolbarDefaultEventHandler;
