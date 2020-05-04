/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.lar;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.xml.Element;

/**
 * @author Matthew Tambara
 */
public interface PermissionImporter {

	public void checkRoles(
			long companyId, long groupId, long userId, Element portletElement)
		throws Exception;

	public void clearCache();

	public void importPortletPermissions(
			long companyId, long groupId, long userId, Layout layout,
			Element portletElement, String portletId)
		throws Exception;

	public void readPortletDataPermissions(
			PortletDataContext portletDataContext)
		throws Exception;

}