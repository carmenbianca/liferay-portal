<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long organizationId = ParamUtil.getLong(request, "organizationId");

Organization organization = OrganizationServiceUtil.fetchOrganization(organizationId);
%>

<liferay-expando:custom-attribute-list
	className="<%= Organization.class.getName() %>"
	classPK="<%= (organization != null) ? organization.getOrganizationId() : 0 %>"
	editable="<%= true %>"
	label="<%= true %>"
/>