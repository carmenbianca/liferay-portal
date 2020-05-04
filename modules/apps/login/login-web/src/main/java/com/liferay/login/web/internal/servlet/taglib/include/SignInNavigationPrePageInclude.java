/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.login.web.internal.servlet.taglib.include;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.include.PageInclude;
import com.liferay.taglib.ui.IconTag;

import java.util.Objects;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Shuyang Zhou
 */
@Component(
	immediate = true,
	property = {
		"login.web.navigation.position=pre", "service.ranking:Integer=100"
	},
	service = PageInclude.class
)
public class SignInNavigationPrePageInclude implements PageInclude {

	@Override
	public void include(PageContext pageContext) throws JspException {
		HttpServletRequest httpServletRequest =
			(HttpServletRequest)pageContext.getRequest();

		String mvcRenderCommandName = httpServletRequest.getParameter(
			"mvcRenderCommandName");

		if (Validator.isNull(mvcRenderCommandName) ||
			Objects.equals(mvcRenderCommandName, "/login/login")) {

			return;
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String signInURL = themeDisplay.getURLSignIn();

		PortletConfig portletConfig =
			(PortletConfig)httpServletRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		String portletName = portletConfig.getPortletName();

		if (portletName.equals(PortletKeys.FAST_LOGIN)) {
			PortletURL fastLoginURL = PortletURLFactoryUtil.create(
				httpServletRequest, PortletKeys.FAST_LOGIN,
				PortletRequest.RENDER_PHASE);

			fastLoginURL.setParameter("saveLastPath", Boolean.FALSE.toString());
			fastLoginURL.setParameter("mvcRenderCommandName", "/login/login");

			try {
				fastLoginURL.setPortletMode(PortletMode.VIEW);
				fastLoginURL.setWindowState(LiferayWindowState.POP_UP);
			}
			catch (PortletException portletException) {
				throw new JspException(portletException);
			}

			signInURL = fastLoginURL.toString();
		}

		IconTag iconTag = new IconTag();

		iconTag.setMessage("sign-in");
		iconTag.setUrl(signInURL);

		iconTag.doTag(pageContext);
	}

}