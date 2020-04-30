<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/common/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.exception.NoSuchLayoutException" %><%@
page import="com.liferay.portal.kernel.servlet.MultiSessionErrors" %><%@
page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil" %><%@
page import="com.liferay.taglib.aui.AUIUtil" %><%@
page import="com.liferay.taglib.util.InlineUtil" %><%@
page import="com.liferay.taglib.util.PortalIncludeUtil" %><%@
page import="com.liferay.taglib.util.TagResourceBundleUtil" %>

<%@ page import="java.io.IOException" %>

<%
PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

String namespace = AUIUtil.getNamespace(portletRequest, portletResponse);

if (Validator.isNull(namespace)) {
	namespace = AUIUtil.getNamespace(request);
}

String currentURL = null;

if ((portletRequest != null) && (portletResponse != null)) {
	PortletURL currentURLObj = PortletURLUtil.getCurrent(PortalUtil.getLiferayPortletRequest(portletRequest), PortalUtil.getLiferayPortletResponse(portletResponse));

	currentURL = currentURLObj.toString();
}
else {
	currentURL = PortalUtil.getCurrentURL(request);
}

ResourceBundle resourceBundle = TagResourceBundleUtil.getResourceBundle(request, locale);

pageContext.setAttribute("resourceBundle", resourceBundle);
%>

<%@ include file="/html/taglib/init-ext.jsp" %>