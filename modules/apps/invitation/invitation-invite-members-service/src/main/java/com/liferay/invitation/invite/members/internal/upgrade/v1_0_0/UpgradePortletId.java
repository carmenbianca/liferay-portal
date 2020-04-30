/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.invitation.invite.members.internal.upgrade.v1_0_0;

import com.liferay.invitation.invite.members.constants.InviteMembersPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Adolfo Pérez
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{"2_WAR_soportlet", InviteMembersPortletKeys.INVITE_MEMBERS}
		};
	}

}