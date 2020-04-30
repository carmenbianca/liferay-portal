/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.manager;

import javax.portlet.ActionRequest;

/**
 * @author Drew Brokke
 */
public interface ContactInfoManager<T> {

	public void delete(long primaryKey) throws Exception;

	public void edit(ActionRequest actionRequest) throws Exception;

	public void makePrimary(long primaryKey) throws Exception;

}