/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.taglib.internal.portlet.action;

import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sharing.configuration.SharingConfiguration;
import com.liferay.sharing.configuration.SharingConfigurationFactory;
import com.liferay.sharing.constants.SharingPortletKeys;
import com.liferay.sharing.taglib.util.CollaboratorsUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SharingPortletKeys.SHARING,
		"mvc.command.name=/sharing/collaborators"
	},
	service = MVCResourceCommand.class
)
public class CollaboratorsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(
			resourceRequest);

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		SharingConfiguration sharingConfiguration =
			_sharingConfigurationFactory.getGroupSharingConfiguration(
				themeDisplay.getSiteGroup());

		if (!sharingConfiguration.isEnabled()) {
			return;
		}

		if (!themeDisplay.isSignedIn()) {
			throw new PrincipalException.MustBeAuthenticated(
				themeDisplay.getUserId());
		}

		long classNameId = _classNameLocalService.getClassNameId(
			ParamUtil.getString(httpServletRequest, "className"));
		long classPK = ParamUtil.getLong(httpServletRequest, "classPK");

		JSONPortletResponseUtil.writeJSON(
			resourceRequest, resourceResponse,
			CollaboratorsUtil.getCollaboratorsJSONObject(
				classNameId, classPK, themeDisplay));
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private SharingConfigurationFactory _sharingConfigurationFactory;

}