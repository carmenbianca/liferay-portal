<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean usersScreenNameAlwaysAutogenerate = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE, PropsValues.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE);
boolean fieldEnableMale = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE, PropsValues.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE);
boolean fieldEnableBirthday = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY, PropsValues.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY);
%>

<aui:fieldset>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:input label="autogenerate-user-screen-names" name='<%= "settings--" + PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE + "--" %>' type="checkbox" value="<%= usersScreenNameAlwaysAutogenerate %>" />

	<aui:input label="enable-birthday" name='<%= "settings--" + PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY + "--" %>' type="checkbox" value="<%= fieldEnableBirthday %>" />

	<aui:input label="enable-gender" name='<%= "settings--" + PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE + "--" %>' type="checkbox" value="<%= fieldEnableMale %>" />
</aui:fieldset>