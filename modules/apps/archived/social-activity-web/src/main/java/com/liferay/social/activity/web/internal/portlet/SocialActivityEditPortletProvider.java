/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.activity.web.internal.portlet;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.EditPortletProvider;
import com.liferay.social.activity.web.internal.constants.SocialActivityPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roberto Díaz
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.social.kernel.model.SocialActivitySetting",
	service = EditPortletProvider.class
)
public class SocialActivityEditPortletProvider
	extends BasePortletProvider implements EditPortletProvider {

	@Override
	public String getPortletName() {
		return SocialActivityPortletKeys.SOCIAL_ACTIVITY;
	}

}