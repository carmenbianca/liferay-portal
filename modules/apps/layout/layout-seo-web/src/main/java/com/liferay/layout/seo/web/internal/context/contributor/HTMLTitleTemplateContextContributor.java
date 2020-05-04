/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.web.internal.context.contributor;

import com.liferay.layout.seo.kernel.LayoutSEOLinkManager;
import com.liferay.layout.seo.web.internal.util.TitleProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateContextContributor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Cristina González
 */
@Component(
	immediate = true,
	property = {
		"lang.type=" + TemplateConstants.LANG_TYPE_FTL,
		"type=" + TemplateContextContributor.TYPE_GLOBAL
	},
	service = TemplateContextContributor.class
)
public class HTMLTitleTemplateContextContributor
	implements TemplateContextContributor {

	@Override
	public void prepare(
		Map<String, Object> contextObjects,
		HttpServletRequest httpServletRequest) {

		try {
			contextObjects.put(
				"htmlTitle", _titleProvider.getTitle(httpServletRequest));
		}
		catch (PortalException portalException) {
			_log.error("Unable to get HTML title ", portalException);
		}
	}

	@Activate
	protected void activate() {
		_titleProvider = new TitleProvider(_layoutSEOLinkManager);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		HTMLTitleTemplateContextContributor.class);

	@Reference
	private LayoutSEOLinkManager _layoutSEOLinkManager;

	private TitleProvider _titleProvider;

}