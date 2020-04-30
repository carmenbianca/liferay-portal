/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib.ui;

/**
 * @author Iván Zaera
 */
public interface URLUIItem extends UIActionItem {

	public String getTarget();

	public String getURL();

	public void setTarget(String target);

	public void setURL(String url);

}