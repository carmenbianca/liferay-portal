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

<div class="alert alert-danger">
	<liferay-ui:message arguments="<%= portletTitle %>" key="is-not-ready" translateArguments="<%= false %>" />
</div>