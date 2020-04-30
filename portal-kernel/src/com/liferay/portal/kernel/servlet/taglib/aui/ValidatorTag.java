/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib.aui;

/**
 * @author Brian Wing Shun Chan
 */
public interface ValidatorTag {

	public void cleanUp();

	public String getBody();

	public String getErrorMessage();

	public String getName();

	public boolean isCustom();

}