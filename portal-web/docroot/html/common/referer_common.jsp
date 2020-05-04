<%--
/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ page session="false" %>

<%@ include file="/html/common/init.jsp" %>

<%
String referer = null;

String refererParam = PortalUtil.escapeRedirect(request.getParameter(WebKeys.REFERER));
String refererRequest = (String)request.getAttribute(WebKeys.REFERER);

String refererSession = null;

HttpSession session = request.getSession(false);

if (session != null) {
	refererSession = (String)session.getAttribute(WebKeys.REFERER);
}

if (Validator.isNotNull(refererParam)) {
	referer = refererParam;
}
else if (Validator.isNotNull(refererRequest)) {
	referer = refererRequest;
}
else if (Validator.isNotNull(refererSession)) {
	referer = refererSession;
}
else if (themeDisplay != null) {
	referer = themeDisplay.getPathMain();
}
else {
	referer = PortalUtil.getPathMain();
}

if ((session != null) && !CookieKeys.hasSessionId(request) && Validator.isNotNull(referer)) {
	referer = PortalUtil.getURLWithSessionId(referer, session.getId());
}
%>