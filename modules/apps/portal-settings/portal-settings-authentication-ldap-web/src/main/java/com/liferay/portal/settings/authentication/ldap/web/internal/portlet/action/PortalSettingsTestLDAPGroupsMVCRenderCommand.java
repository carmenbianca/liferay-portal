/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.authentication.ldap.web.internal.portlet.action;

import com.liferay.configuration.admin.constants.ConfigurationAdminPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderConstants;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Philip Jones
 */
@Component(
	property = {
		"javax.portlet.name=" + ConfigurationAdminPortletKeys.INSTANCE_SETTINGS,
		"mvc.command.name=/portal_settings/test_ldap_groups"
	},
	service = MVCRenderCommand.class
)
public class PortalSettingsTestLDAPGroupsMVCRenderCommand
	extends BasePortalSettingsMVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			AuthTokenUtil.checkCSRFToken(
				_portal.getOriginalServletRequest(
					_portal.getHttpServletRequest(renderRequest)),
				getClass().getName());

			return super.render(renderRequest, renderResponse);
		}
		catch (PrincipalException principalException) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Unable to test LDAP connection: " +
						principalException.getMessage(),
					principalException);
			}
			else if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to test LDAP connection: " +
						principalException.getMessage());
			}
		}

		return MVCRenderConstants.MVC_PATH_VALUE_SKIP_DISPATCH;
	}

	@Override
	protected String getJspPath() {
		return _JSP_PATH;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.portal.settings.authentication.ldap.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		super.servletContext = servletContext;
	}

	private static final String _JSP_PATH =
		"/com.liferay.portal.settings.web/test_ldap_groups.jsp";

	private static final Log _log = LogFactoryUtil.getLog(
		PortalSettingsTestLDAPGroupsMVCRenderCommand.class);

	@Reference
	private Portal _portal;

}