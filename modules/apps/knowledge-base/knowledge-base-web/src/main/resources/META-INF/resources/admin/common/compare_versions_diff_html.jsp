<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/common/init.jsp" %>

<%
String diffHtmlResults = (String)request.getAttribute(WebKeys.DIFF_HTML_RESULTS);
double diffVersion = GetterUtil.getDouble(request.getAttribute(WebKeys.DIFF_VERSION));

String infoMessage = StringPool.BLANK;

if (diffVersion > 0) {
	infoMessage = LanguageUtil.format(request, "unable-to-render-version-x", diffVersion);
}
%>

<liferay-ui:diff-html
	diffHtmlResults="<%= diffHtmlResults %>"
	infoMessage="<%= infoMessage %>"
/>