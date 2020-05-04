/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

class AccountRolesManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteAccountRoles(itemData) {
		if (
			confirm(
				Liferay.Language.get(
					'are-you-sure-you-want-to-delete-the-selected-roles'
				)
			)
		) {
			const form = this.one('#fm');

			Liferay.Util.postForm(form, {
				data: {
					accountRoleIds: Liferay.Util.listCheckedExcept(
						form,
						this.ns('allRowIds')
					),
				},
				url: itemData.deleteAccountRolesURL,
			});
		}
	}
}

export default AccountRolesManagementToolbarDefaultEventHandler;
