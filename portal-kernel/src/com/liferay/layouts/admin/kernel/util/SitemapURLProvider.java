/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layouts.admin.kernel.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.xml.Element;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author     Eduardo García
 * @deprecated As of Mueller (7.2.x), replaced by {@link
 *             com.liferay.layout.admin.kernel.util.SitemapURLProvider}
 */
@Deprecated
@ProviderType
public interface SitemapURLProvider {

	public String getClassName();

	public void visitLayout(
			Element element, String layoutUuid, LayoutSet layoutSet,
			ThemeDisplay themeDisplay)
		throws PortalException;

	public void visitLayoutSet(
			Element element, LayoutSet layoutSet, ThemeDisplay themeDisplay)
		throws PortalException;

}