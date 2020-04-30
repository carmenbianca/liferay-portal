<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
try {
%>

	<%= xslContentDisplayContext.getContent(request) %>

<%
}
catch (Exception e) {
	_log.error(e.getMessage());
%>

	<div class="alert alert-danger">
		<liferay-ui:message key="an-error-occurred-while-processing-your-xml-and-xsl" />
	</div>

<%
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("com_liferay_xsl_content_web.view_jsp");
%>