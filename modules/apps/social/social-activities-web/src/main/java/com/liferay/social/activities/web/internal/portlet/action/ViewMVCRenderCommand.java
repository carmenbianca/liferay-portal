/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.activities.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.social.activities.constants.SocialActivitiesPortletKeys;
import com.liferay.social.activities.web.internal.constants.SocialActivitiesWebKeys;
import com.liferay.social.activities.web.internal.util.SocialActivitiesQueryHelper;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SocialActivitiesPortletKeys.SOCIAL_ACTIVITIES,
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		renderRequest.setAttribute(
			SocialActivitiesWebKeys.SOCIAL_ACTIVITIES_QUERY_HELPER,
			_socialActivitiesQueryHelper);

		return "/view.jsp";
	}

	@Reference(unbind = "-")
	protected void setSocialActivitiesQueryHelper(
		SocialActivitiesQueryHelper socialActivitiesQueryHelper) {

		_socialActivitiesQueryHelper = socialActivitiesQueryHelper;
	}

	private SocialActivitiesQueryHelper _socialActivitiesQueryHelper;

}