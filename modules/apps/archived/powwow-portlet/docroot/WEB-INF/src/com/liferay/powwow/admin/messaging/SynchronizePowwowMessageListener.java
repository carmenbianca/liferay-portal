/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.admin.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.powwow.service.PowwowMeetingLocalServiceUtil;
import com.liferay.powwow.service.PowwowServerLocalServiceUtil;

/**
 * @author Shinn Lok
 */
public class SynchronizePowwowMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		PowwowMeetingLocalServiceUtil.checkPowwowMeetings();
		PowwowServerLocalServiceUtil.checkPowwowServers();
	}

}