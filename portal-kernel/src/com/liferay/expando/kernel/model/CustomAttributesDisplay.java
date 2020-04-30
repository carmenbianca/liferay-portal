/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.model;

/**
 * @author Jorge Ferrer
 */
public interface CustomAttributesDisplay {

	public String getClassName();

	public String getIconCssClass();

	public String getPortletId();

	public void setClassNameId(long classNameId);

	public void setPortletId(String portletId);

}