/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

class LayoutsManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	convertSelectedPages(itemData) {
		if (
			confirm(
				Liferay.Language.get(
					'are-you-sure-you-want-to-convert-the-selected-pages'
				)
			)
		) {
			this._send(itemData.convertLayoutURL);
		}
	}

	deleteSelectedPages(itemData) {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			this._send(itemData.deleteLayoutURL);
		}
	}

	_send(url) {
		submitForm(this.one('#fm'), url);
	}
}

export default LayoutsManagementToolbarDefaultEventHandler;
