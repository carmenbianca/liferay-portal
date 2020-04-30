<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String portletResource = ParamUtil.getString(request, "portletResource");

Portlet selPortlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletResource);
%>

<aui:script>
	Liferay.fire('closeWindow', {
		id: '_<%= HtmlUtil.escapeJS(selPortlet.getPortletId()) %>_addMenuItem',
		portletAjaxable: <%= selPortlet.isAjaxable() %>,
		refresh: '<%= HtmlUtil.escapeJS(selPortlet.getPortletId()) %>',
	});
</aui:script>