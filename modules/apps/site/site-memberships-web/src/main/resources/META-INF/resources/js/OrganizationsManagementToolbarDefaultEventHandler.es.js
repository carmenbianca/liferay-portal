/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, ItemSelectorDialog} from 'frontend-js-web';
import dom from 'metal-dom';

class OrganizationsManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteSelectedOrganizations() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}

	selectOrganizations(itemData) {
		const itemSelectorDialog = new ItemSelectorDialog({
			buttonAddLabel: Liferay.Language.get('done'),
			eventName: this.ns('selectOrganizations'),
			title: Liferay.Util.sub(
				Liferay.Language.get('assign-organizations-to-this-x'),
				itemData.groupTypeLabel
			),
			url: itemData.selectOrganizationsURL,
		});

		itemSelectorDialog.on('selectedItemChange', event => {
			const selectedItem = event.selectedItem;

			if (selectedItem) {
				const addGroupOrganizationsFm = this.one(
					'#addGroupOrganizationsFm'
				);

				selectedItem.forEach(item => {
					dom.append(addGroupOrganizationsFm, item);
				});

				submitForm(addGroupOrganizationsFm);
			}
		});

		itemSelectorDialog.open();
	}
}

export default OrganizationsManagementToolbarDefaultEventHandler;
