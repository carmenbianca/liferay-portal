<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
List<User> users = UserLocalServiceUtil.search(company.getCompanyId(), null, WorkflowConstants.STATUS_APPROVED, null, 0, 10, (OrderByComparator)null);

request.setAttribute("users", users);
%>

<display:table
	name="users"
>
	<display:column
		property="userId"
		title="User ID"
	/>

	<display:column
		property="emailAddress"
		title="Email Address"
	/>
</display:table>

<%
Class<?> clazz = request.getClass();

System.out.println(clazz.getName());
System.out.println("request.getRemoteUser() " + request.getRemoteUser());

PortalServiceUtil.testGetUserId();
%>

Test