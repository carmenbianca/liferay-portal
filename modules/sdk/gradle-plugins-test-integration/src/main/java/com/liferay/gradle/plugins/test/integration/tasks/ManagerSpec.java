/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.test.integration.tasks;

/**
 * @author Andrea Di Giorgi
 */
public interface ManagerSpec {

	public String getManagerPassword();

	public String getManagerUserName();

	public void setManagerPassword(Object managerPassword);

	public void setManagerUserName(Object managerUserName);

}