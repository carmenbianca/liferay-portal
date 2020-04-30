/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, openSimpleInputModal} from 'frontend-js-web';
import {Config} from 'metal-state';

class MasterLayoutManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	addMasterLayout(itemData) {
		openSimpleInputModal({
			dialogTitle: Liferay.Language.get('add-master-page'),
			formSubmitURL: itemData.addMasterLayoutURL,
			mainFieldLabel: Liferay.Language.get('name'),
			mainFieldName: 'name',
			mainFieldPlaceholder: Liferay.Language.get('name'),
			namespace: this.namespace,
			spritemap: this.spritemap,
		});
	}

	deleteSelectedMasterLayouts() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}
}

MasterLayoutManagementToolbarDefaultEventHandler.STATE = {
	spritemap: Config.string(),
};

export default MasterLayoutManagementToolbarDefaultEventHandler;
