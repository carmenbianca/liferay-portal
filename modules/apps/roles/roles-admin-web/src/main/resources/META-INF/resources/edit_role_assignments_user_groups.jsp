<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String displayStyle = (String)request.getAttribute("edit_role_assignments.jsp-displayStyle");

SearchContainer searchContainer = (SearchContainer)request.getAttribute("edit_role_assignments.jsp-searchContainer");
%>

<liferay-ui:search-container
	id="assigneesSearch"
	searchContainer="<%= searchContainer %>"
	var="userGroupSearchContainer"
>
	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.UserGroup"
		escapedModel="<%= true %>"
		keyProperty="group.groupId"
		modelVar="userGroup"
	>
		<%@ include file="/user_group_columns.jspf" %>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		displayStyle="<%= displayStyle %>"
		markupView="lexicon"
	/>
</liferay-ui:search-container>