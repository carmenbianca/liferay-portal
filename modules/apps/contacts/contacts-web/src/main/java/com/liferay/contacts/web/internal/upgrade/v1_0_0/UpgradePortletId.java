/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.web.internal.upgrade.v1_0_0;

import com.liferay.contacts.web.internal.constants.ContactsPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Drew Brokke
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"1_WAR_contactsportlet", ContactsPortletKeys.CONTACTS_CENTER},
			{"4_WAR_contactsportlet", ContactsPortletKeys.MEMBERS},
			{"3_WAR_contactsportlet", ContactsPortletKeys.MY_CONTACTS},
			{"2_WAR_contactsportlet", ContactsPortletKeys.PROFILE}
		};
	}

}