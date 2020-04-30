/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

class EditRoleAssignmentsManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	addSegmentEntry(itemData) {
		window.sessionStorage.setItem(itemData.sessionKey, 'open');

		Liferay.Util.getTop().location.href = itemData.addSegmentEntryURL;
	}
}

export default EditRoleAssignmentsManagementToolbarDefaultEventHandler;
