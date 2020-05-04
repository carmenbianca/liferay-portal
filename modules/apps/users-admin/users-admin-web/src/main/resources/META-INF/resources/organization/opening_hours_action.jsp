<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
OrganizationScreenNavigationDisplayContext organizationScreenNavigationDisplayContext = (OrganizationScreenNavigationDisplayContext)request.getAttribute(UsersAdminWebKeys.ORGANIZATION_SCREEN_NAVIGATION_DISPLAY_CONTEXT);

long organizationId = organizationScreenNavigationDisplayContext.getOrganizationId();

long orgLaborId = ParamUtil.getLong(request, "orgLaborId");
%>

<liferay-ui:icon-menu
	direction="right-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>

	<%
	PortletURL editURL = liferayPortletResponse.createRenderURL();

	editURL.setParameter("mvcPath", "/organization/edit_opening_hours.jsp");
	editURL.setParameter("redirect", currentURL);
	editURL.setParameter("className", Organization.class.getName());
	editURL.setParameter("classPK", String.valueOf(organizationId));
	editURL.setParameter("primaryKey", String.valueOf(orgLaborId));
	%>

	<liferay-ui:icon
		message="edit"
		url="<%= editURL.toString() %>"
	/>

	<portlet:actionURL name="/users_admin/update_contact_information" var="removeOpeningHoursUrl">
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="className" value="<%= Organization.class.getName() %>" />
		<portlet:param name="classPK" value="<%= String.valueOf(organizationId) %>" />
		<portlet:param name="listType" value="<%= ListTypeConstants.ORGANIZATION_SERVICE %>" />
		<portlet:param name="primaryKey" value="<%= String.valueOf(orgLaborId) %>" />
	</portlet:actionURL>

	<liferay-ui:icon
		message="remove"
		url="<%= removeOpeningHoursUrl %>"
	/>
</liferay-ui:icon-menu>