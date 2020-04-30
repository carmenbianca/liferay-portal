/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector;

import java.io.IOException;

import javax.portlet.PortletURL;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

/**
 * @author Iván Zaera
 */
public interface ItemSelectorViewRenderer {

	public String getItemSelectedEventName();

	public ItemSelectorCriterion getItemSelectorCriterion();

	public ItemSelectorView<ItemSelectorCriterion> getItemSelectorView();

	public PortletURL getPortletURL();

	public void renderHTML(PageContext pageContext)
		throws IOException, ServletException;

}