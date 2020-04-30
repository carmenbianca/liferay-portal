/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

class AccountEntriesManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	activateAccountEntries(itemData) {
		this._updateAccountEntries(itemData.activateAccountEntriesURL);
	}

	deactivateAccountEntries(itemData) {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-deactivate-this')
			)
		) {
			this._updateAccountEntries(itemData.deactivateAccountEntriesURL);
		}
	}

	deleteAccountEntries(itemData) {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			this._updateAccountEntries(itemData.deleteAccountEntriesURL);
		}
	}

	_updateAccountEntries(url) {
		const form = this.one('#fm');

		Liferay.Util.postForm(form, {
			data: {
				accountEntryIds: Liferay.Util.listCheckedExcept(
					form,
					this.ns('allRowIds')
				),
			},
			url,
		});
	}
}

export default AccountEntriesManagementToolbarDefaultEventHandler;
