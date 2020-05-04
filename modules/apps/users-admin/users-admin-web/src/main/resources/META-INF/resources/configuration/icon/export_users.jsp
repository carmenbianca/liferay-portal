<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
int status = GetterUtil.getInteger(request.getAttribute(UsersAdminWebKeys.STATUS), WorkflowConstants.STATUS_APPROVED);
%>

<liferay-portlet:resourceURL id="/users_admin/export_users" var="exportURL">
	<liferay-portlet:param name="status" value="<%= String.valueOf(status) %>" />
</liferay-portlet:resourceURL>

<liferay-util:buffer
	var="onClickFn"
>
	if (confirm('<liferay-ui:message key="warning-this-csv-file-contains-user-supplied-inputs" unicode="<%= true %>" />')) {
		submitForm(document.hrefFm, '<%= exportURL + "&compress=0&etag=0&strip=0" %>');
	}
</liferay-util:buffer>

<liferay-ui:icon
	message="export-users"
	method="get"
	onClick="<%= onClickFn %>"
	url="javascript:;"
/>