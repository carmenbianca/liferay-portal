<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/action/init.jsp" %>

<%
String layoutTemplateId = GetterUtil.getString(typeSettingsProperties.getProperty("layoutTemplateId"), PropsValues.DEFAULT_LAYOUT_TEMPLATE_ID);
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="layout"
/>

<h5><liferay-ui:message key="layout-template" /></h5>

<liferay-ui:layout-templates-list
	layoutTemplateId="<%= layoutTemplateId %>"
	layoutTemplates="<%= LayoutTemplateLocalServiceUtil.getLayoutTemplates() %>"
/>