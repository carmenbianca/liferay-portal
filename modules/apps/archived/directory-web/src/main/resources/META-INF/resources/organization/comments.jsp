<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long organizationId = ParamUtil.getLong(request, "organizationId");

Organization organization = OrganizationServiceUtil.fetchOrganization(organizationId);
%>

<c:if test="<%= Validator.isNotNull(organization.getComments()) %>">
	<h3 class="icon-comment"><liferay-ui:message key="comments" /></h3>

	<%= MBUtil.getBBCodeHTML(organization.getComments(), themeDisplay.getPathThemeImages()) %>
</c:if>