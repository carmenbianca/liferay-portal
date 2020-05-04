/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.jabber;

import java.util.List;

/**
 * @author Bruno Farache
 */
public interface Jabber {

	public void disconnect(long userId);

	public String getResource(String jabberId);

	public String getScreenName(String jabberId);

	public List<Object[]> getStatuses(
		long companyId, long userId, List<Object[]> buddies);

	public void login(long userId, String password);

	public void sendMessage(long fromUserId, long toUserId, String content);

	public void updatePassword(long userId, String password);

	public void updateStatus(long userId, int online);

}