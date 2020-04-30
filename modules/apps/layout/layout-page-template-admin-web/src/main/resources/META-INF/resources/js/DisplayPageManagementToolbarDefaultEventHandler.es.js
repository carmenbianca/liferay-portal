/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';
import {Config} from 'metal-state';

class DisplayPageManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteSelectedDisplayPages() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}
}

DisplayPageManagementToolbarDefaultEventHandler.STATE = {
	spritemap: Config.string(),
};

export default DisplayPageManagementToolbarDefaultEventHandler;
