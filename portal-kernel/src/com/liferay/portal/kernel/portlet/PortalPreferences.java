/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface PortalPreferences extends Serializable {

	public long getUserId();

	public String getValue(String namespace, String key);

	public String getValue(String namespace, String key, String defaultValue);

	public String[] getValues(String namespace, String key);

	public String[] getValues(
		String namespace, String key, String[] defaultValue);

	public boolean isSignedIn();

	public void resetValues(String namespace);

	public void setSignedIn(boolean signedIn);

	public void setUserId(long userId);

	public void setValue(String namespace, String key, String value);

	public void setValues(String namespace, String key, String[] values);

	public int size();

}