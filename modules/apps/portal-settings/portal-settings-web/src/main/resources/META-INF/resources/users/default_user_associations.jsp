<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String adminDefaultGroupNames = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_DEFAULT_GROUP_NAMES);
String adminDefaultOrganizationGroupNames = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_DEFAULT_ORGANIZATION_GROUP_NAMES);
String adminDefaultRoleNames = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_DEFAULT_ROLE_NAMES);
String adminDefaultUserGroupNames = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_DEFAULT_USER_GROUP_NAMES);
boolean adminSyncDefaultAssociations = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_SYNC_DEFAULT_ASSOCIATIONS, PropsValues.ADMIN_SYNC_DEFAULT_ASSOCIATIONS);
%>

<aui:fieldset>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:input helpMessage="check-to-apply-the-changes-to-existing-users" label="apply-to-existing-users" name='<%= "settings--" + PropsKeys.ADMIN_SYNC_DEFAULT_ASSOCIATIONS + "--" %>' type="checkbox" value="<%= adminSyncDefaultAssociations %>" />

	<aui:input helpMessage="enter-the-default-site-names-per-line-that-are-associated-with-newly-created-users" label="sites" name='<%= "settings--" + PropsKeys.ADMIN_DEFAULT_GROUP_NAMES + "--" %>' type="textarea" value="<%= adminDefaultGroupNames %>" />

	<aui:input helpMessage="enter-the-default-organization-site-names-per-line-that-are-associated-with-newly-created-users" label="organization-sites" name='<%= "settings--" + PropsKeys.ADMIN_DEFAULT_ORGANIZATION_GROUP_NAMES + "--" %>' type="textarea" value="<%= adminDefaultOrganizationGroupNames %>" />

	<aui:input helpMessage="enter-the-default-regular-role-names-per-line-that-are-associated-with-newly-created-users" label="regular-roles" name='<%= "settings--" + PropsKeys.ADMIN_DEFAULT_ROLE_NAMES + "--" %>' type="textarea" value="<%= adminDefaultRoleNames %>" />

	<aui:input helpMessage="enter-the-default-user-group-names-per-line-that-are-associated-with-newly-created-users" label="user-groups" name='<%= "settings--" + PropsKeys.ADMIN_DEFAULT_USER_GROUP_NAMES + "--" %>' type="textarea" value="<%= adminDefaultUserGroupNames %>" />
</aui:fieldset>