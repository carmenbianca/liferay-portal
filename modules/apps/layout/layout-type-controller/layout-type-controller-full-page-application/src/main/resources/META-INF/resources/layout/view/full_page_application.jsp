<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/layout/view/init.jsp" %>

<%
String ppid = ParamUtil.getString(request, "p_p_id");

UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();

if (Validator.isNull(ppid)) {
	ppid = typeSettingsProperties.getProperty("fullPageApplicationPortlet");
}

String velocityTemplateId = theme.getThemeId() + LayoutTemplateConstants.STANDARD_SEPARATOR + "max";
String velocityTemplateContent = LayoutTemplateLocalServiceUtil.getContent("max", true, theme.getThemeId());

if (Validator.isNotNull(velocityTemplateContent)) {
	RuntimePageUtil.processTemplate(request, response, ppid, new StringTemplateResource(velocityTemplateId, velocityTemplateContent));
}
%>

<liferay-ui:layout-common />