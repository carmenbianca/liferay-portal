<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/layout/view/init.jsp" %>

<%
String ppid = ParamUtil.getString(request, "p_p_id");
String velocityTemplateId = theme.getThemeId() + LayoutTemplateConstants.STANDARD_SEPARATOR + "pop_up";
String velocityTemplateContent = LayoutTemplateLocalServiceUtil.getContent("pop_up", true, theme.getThemeId());

if (Validator.isNotNull(velocityTemplateContent)) {
	RuntimePageUtil.processTemplate(request, response, ppid, new StringTemplateResource(velocityTemplateId, velocityTemplateContent));
}
%>

<liferay-ui:layout-common />