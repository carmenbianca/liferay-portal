/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

class FragmentEntryUsageManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	propagate() {
		submitForm(this.one('#fm'));
	}
}
export default FragmentEntryUsageManagementToolbarDefaultEventHandler;
