/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';

class AccountOrganizationsManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	removeOrganizations(itemData) {
		if (
			confirm(
				Liferay.Language.get(
					'are-you-sure-you-want-to-remove-the-selected-organizations'
				)
			)
		) {
			const form = this.one('#fm');

			Liferay.Util.postForm(form, {
				data: {
					accountOrganizationIds: Liferay.Util.listCheckedExcept(
						form,
						this.ns('allRowIds')
					),
				},
				url: itemData.removeOrganizationsURL,
			});
		}
	}

	selectAccountOrganizations(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			buttonAddLabel: Liferay.Language.get('assign'),
			eventName: this.ns('assignAccountOrganizations'),
			title: Liferay.Util.sub(
				Liferay.Language.get('assign-organizations-to-x'),
				itemData.accountEntryName
			),
			url: itemData.selectAccountOrganizationsURL,
		});

		itemSelectorDialog.open();

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const form = this.one('#fm');

				Liferay.Util.postForm(form, {
					data: {
						accountOrganizationIds: selectedItem.value,
					},
					url: itemData.assignAccountOrganizationsURL,
				});
			}
		});
	}
}

export default AccountOrganizationsManagementToolbarDefaultEventHandler;
