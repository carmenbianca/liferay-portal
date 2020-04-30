/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.servlet.ServletContext;

/**
 * @author Jorge Ferrer
 * @author Dennis Ju
 * @author Brian Wing Shun Chan
 */
public interface PortletLister {

	public TreeView getTreeView() throws PortalException;

	public void setHierarchicalTree(boolean hierarchicalTree);

	public void setIncludeInstanceablePortlets(
		boolean includeInstanceablePortlets);

	public void setIteratePortlets(boolean iteratePortlets);

	public void setLayoutTypePortlet(LayoutTypePortlet layoutTypePortlet);

	public void setRootNodeName(String rootNodeName);

	public void setServletContext(ServletContext servletContext);

	public void setThemeDisplay(ThemeDisplay themeDisplay);

	public void setUser(User user);

}