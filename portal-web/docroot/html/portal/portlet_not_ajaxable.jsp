<%--
/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<portlet:defineObjects />

<%
String portletTitle = HtmlUtil.escape(PortalUtil.getPortletTitle(renderResponse));

if (portletTitle == null) {
	portletTitle = LanguageUtil.get(request, "portlet");
}
%>

<div class="alert alert-info">
	<liferay-ui:message arguments="<%= portletTitle %>" key="x-will-only-be-shown-after-you-refresh-the-page" translateArguments="<%= false %>" />
</div>