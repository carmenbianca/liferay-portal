/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib.ui;

/**
 * @author Iván Zaera
 */
public interface UIActionItem extends UIItem {

	public String getIcon();

	public String getLabel();

	public void setIcon(String icon);

	public void setLabel(String label);

}