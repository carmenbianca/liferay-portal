<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/polls_display/init.jsp" %>

<%
Portlet portlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletDisplay.getId());
%>

<aui:script>
	Liferay.fire('closeWindow', {
		id: '<portlet:namespace />editQuestion',
		portletAjaxable: <%= portlet.isAjaxable() %>,
		refresh: '<%= portletDisplay.getId() %>',
	});
</aui:script>