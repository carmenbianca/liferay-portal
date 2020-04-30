/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler, openSimpleInputModal} from 'frontend-js-web';
import {Config} from 'metal-state';

class LayoutPageTemplateEntryManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	addLayoutPageTemplateEntry(itemData) {
		openSimpleInputModal({
			dialogTitle: Liferay.Language.get('add-page-template'),
			formSubmitURL: itemData.addPageTemplateURL,
			mainFieldLabel: Liferay.Language.get('name'),
			mainFieldName: 'name',
			mainFieldPlaceholder: Liferay.Language.get('name'),
			namespace: this.namespace,
			spritemap: this.spritemap,
		});
	}

	deleteLayoutPageTemplateEntries() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}

	exportLayoutPageTemplateEntries(itemData) {
		submitForm(this.one('#fm'), itemData.exportLayoutPageTemplateEntryURL);
	}
}

LayoutPageTemplateEntryManagementToolbarDefaultEventHandler.STATE = {
	spritemap: Config.string(),
};

export default LayoutPageTemplateEntryManagementToolbarDefaultEventHandler;
