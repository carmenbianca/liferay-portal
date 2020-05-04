/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mentions.web.internal.editor.configuration;

import com.liferay.layout.content.page.editor.constants.ContentPageEditorPortletKeys;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ambrín Chaudhary
 */
@Component(
	property = {
		"editor.config.key=pageEditorCommentEditor",
		"javax.portlet.name=" + ContentPageEditorPortletKeys.CONTENT_PAGE_EDITOR_PORTLET,
		"service.ranking:Integer=10"
	},
	service = EditorConfigContributor.class
)
public class PageCommentsMentionsEditorConfigContributor
	extends BaseMentionsEditorConfigContributor {

	@Override
	protected PortletURL getPortletURL(
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		PortletURL portletURL = super.getPortletURL(
			themeDisplay, requestBackedPortletURLFactory);

		portletURL.setParameter(
			"strategy",
			JSONUtil.put(
				"plid", themeDisplay.getPlid()
			).put(
				"strategy", "pageEditorCommentStrategy"
			).toJSONString());

		return portletURL;
	}

}