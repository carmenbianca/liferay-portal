/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';
import {Config} from 'metal-state';

class ManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteSelectedEntries() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}

	restoreSelectedEntries() {
		submitForm(this.one('#fm'), this.restoreEntriesURL);
	}
}

ManagementToolbarDefaultEventHandler.STATE = {
	restoreEntriesURL: Config.string(),
};

export default ManagementToolbarDefaultEventHandler;
