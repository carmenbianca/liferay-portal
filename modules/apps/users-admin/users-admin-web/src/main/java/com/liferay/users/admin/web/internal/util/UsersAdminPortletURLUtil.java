/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.OrganizationPermissionUtil;

import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;

/**
 * @author Samuel Trong Tran
 */
public class UsersAdminPortletURLUtil {

	public static String createOrganizationViewTreeURL(
		long organizationId, RenderResponse renderResponse) {

		RenderURL renderURL = renderResponse.createRenderURL();

		renderURL.setParameter("mvcRenderCommandName", "/users_admin/view");
		renderURL.setParameter("toolbarItem", "view-all-organizations");

		if (organizationId ==
				OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID) {

			renderURL.setParameter(
				"usersListView", UserConstants.LIST_VIEW_FLAT_ORGANIZATIONS);
		}
		else {
			renderURL.setParameter(
				"organizationId", String.valueOf(organizationId));
			renderURL.setParameter(
				"usersListView", UserConstants.LIST_VIEW_TREE);
		}

		return String.valueOf(renderURL);
	}

	public static String createParentOrganizationViewTreeURL(
			long organizationId, RenderResponse renderResponse)
		throws PortalException {

		return createParentOrganizationViewTreeURL(
			OrganizationLocalServiceUtil.fetchOrganization(organizationId),
			renderResponse);
	}

	public static String createParentOrganizationViewTreeURL(
			Organization organization, RenderResponse renderResponse)
		throws PortalException {

		if ((organization != null) && !organization.isRoot()) {
			long parentOrganizationId = organization.getParentOrganizationId();

			if (OrganizationPermissionUtil.contains(
					PermissionThreadLocal.getPermissionChecker(),
					parentOrganizationId, ActionKeys.VIEW)) {

				return createOrganizationViewTreeURL(
					parentOrganizationId, renderResponse);
			}
		}

		return createOrganizationViewTreeURL(
			OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID,
			renderResponse);
	}

}