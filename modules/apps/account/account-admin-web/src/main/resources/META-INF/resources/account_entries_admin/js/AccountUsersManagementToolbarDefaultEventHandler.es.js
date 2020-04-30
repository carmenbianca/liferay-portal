/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';

class AccountUsersManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	removeUsers(itemData) {
		if (
			confirm(
				Liferay.Language.get(
					'are-you-sure-you-want-to-remove-the-selected-users'
				)
			)
		) {
			const form = this.one('#fm');

			Liferay.Util.postForm(form, {
				data: {
					accountUserIds: Liferay.Util.listCheckedExcept(
						form,
						this.ns('allRowIds')
					),
				},
				url: itemData.removeUsersURL,
			});
		}
	}

	selectAccountUsers(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			buttonAddLabel: Liferay.Language.get('assign'),
			eventName: this.ns('assignAccountUsers'),
			title: Liferay.Util.sub(
				Liferay.Language.get('assign-users-to-x'),
				itemData.accountEntryName
			),
			url: itemData.selectAccountUsersURL,
		});

		itemSelectorDialog.open();

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const form = this.one('#fm');

				Liferay.Util.postForm(form, {
					data: {
						accountUserIds: selectedItem.value,
					},
					url: itemData.assignAccountUsersURL,
				});
			}
		});
	}
}

export default AccountUsersManagementToolbarDefaultEventHandler;
