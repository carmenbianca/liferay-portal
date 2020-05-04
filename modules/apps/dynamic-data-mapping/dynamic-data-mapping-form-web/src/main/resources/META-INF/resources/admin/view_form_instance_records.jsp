<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/init.jsp" %>

<%
DDMFormViewFormInstanceRecordsDisplayContext ddmFormViewFormInstanceRecordsDisplayContext = ddmFormAdminDisplayContext.getFormViewRecordsDisplayContext();

renderResponse.setTitle(LanguageUtil.get(request, "form-entries"));
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= ddmFormViewFormInstanceRecordsDisplayContext.getNavigationItems() %>"
/>

<liferay-util:include page="/admin/form_instance_records_search_container.jsp" servletContext="<%= application %>" />