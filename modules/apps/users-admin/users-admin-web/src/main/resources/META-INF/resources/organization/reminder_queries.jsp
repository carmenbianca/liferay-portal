<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
OrganizationScreenNavigationDisplayContext organizationScreenNavigationDisplayContext = (OrganizationScreenNavigationDisplayContext)request.getAttribute(UsersAdminWebKeys.ORGANIZATION_SCREEN_NAVIGATION_DISPLAY_CONTEXT);

Organization organization = organizationScreenNavigationDisplayContext.getOrganization();

String xml = LocalizationUtil.getLocalizationXmlFromPreferences(organization.getPreferences(), renderRequest, "reminderQueries");
%>

<div class="sheet-text">
	<liferay-ui:message key="specify-custom-security-questions-for-the-users-of-this-organization" />
</div>

<aui:input id="reminderQueries" label="security-questions" localized="<%= true %>" name="reminderQueries" type="textarea" value="<%= xml %>" />