/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

import confirmDepotEntryDeletion from './confirmDepotEntryDeletion.es';

class DepotEntryDropdownDefaultEventHandler extends DefaultEventHandler {
	deleteDepotEntry(itemData) {
		if (confirmDepotEntryDeletion()) {
			submitForm(document.hrefFm, itemData.deleteDepotEntryURL);
		}
	}

	permissionsDepotEntry(itemData) {
		this._openWindow(
			Liferay.Language.get('permissions'),
			itemData.permissionsDepotEntryURL
		);
	}

	_openWindow(label, url) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				modal: true,
			},
			dialogIframe: {
				bodyCssClass: 'dialog-with-footer',
			},
			title: Liferay.Language.get(label),
			uri: url,
		});
	}
}

export default DepotEntryDropdownDefaultEventHandler;
