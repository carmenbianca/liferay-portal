<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.captcha.configuration.CaptchaConfiguration" %><%@
page import="com.liferay.captcha.util.CaptchaUtil" %><%@
page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%
CaptchaConfiguration captchaConfiguration = (CaptchaConfiguration)ConfigurationProviderUtil.getSystemConfiguration(CaptchaConfiguration.class);

boolean captchaEnabled = false;

if (portletRequest != null) {
	captchaEnabled = CaptchaUtil.isEnabled(portletRequest);
}
else {
	captchaEnabled = CaptchaUtil.isEnabled(request);
}
%>