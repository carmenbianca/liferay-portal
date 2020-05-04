/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.taglib.servlet.taglib;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.taglib.internal.servlet.ServletContextUtil;
import com.liferay.dynamic.data.mapping.taglib.internal.util.PortletDisplayTemplateUtil;
import com.liferay.dynamic.data.mapping.taglib.servlet.taglib.base.BaseTemplateRendererTag;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.FileAvailabilityUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * @author Eduardo García
 */
public class TemplateRendererTag extends BaseTemplateRendererTag {

	@Override
	public int doStartTag() throws JspException {
		try {
			String page = getStartPage();

			setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

			callSetAttributes();

			if (themeResourceExists(page)) {
				doIncludeTheme(page);

				return EVAL_BODY_INCLUDE;
			}

			if (!FileAvailabilityUtil.isAvailable(servletContext, page)) {
				logUnavailablePage(page);
			}

			doInclude(page, true);

			if (_portletDisplayDDMTemplate != null) {
				return SKIP_BODY;
			}

			return EVAL_BODY_INCLUDE;
		}
		catch (Exception exception) {
			throw new JspException(exception);
		}
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(ServletContextUtil.getServletContext());
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_portletDisplayDDMTemplate = null;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		super.setAttributes(httpServletRequest);

		long displayStyleGroupId = getDisplayStyleGroupId();

		if (displayStyleGroupId == 0) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			displayStyleGroupId = themeDisplay.getScopeGroupId();

			setNamespacedAttribute(
				httpServletRequest, "displayStyleGroupId", displayStyleGroupId);
		}

		_portletDisplayDDMTemplate =
			PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplate(
				displayStyleGroupId, PortalUtil.getClassNameId(getClassName()),
				getDisplayStyle(), true);

		setNamespacedAttribute(
			httpServletRequest, "portletDisplayDDMTemplate",
			_portletDisplayDDMTemplate);
	}

	private DDMTemplate _portletDisplayDDMTemplate;

}