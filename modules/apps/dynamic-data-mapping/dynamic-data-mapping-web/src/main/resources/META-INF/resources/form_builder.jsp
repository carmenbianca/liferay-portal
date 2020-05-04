<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String portletResourceNamespace = ParamUtil.getString(request, "portletResourceNamespace");

long structureId = ParamUtil.getLong(request, "structureId");
String className = ParamUtil.getString(request, "className");
String script = ParamUtil.getString(request, "script");
String fieldsJSONArrayString = ParamUtil.getString(request, "fieldsJSONArrayString");

scopeAvailableFields = ParamUtil.getString(request, "scopeAvailableFields");
scopeClassNameId = PortalUtil.getClassNameId(className);
scopeStorageType = ParamUtil.getString(request, "storageType");

DDMStructure structure = null;

if (structureId > 0) {
	structure = DDMStructureServiceUtil.getStructure(structureId);
}

Portlet portlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletDisplay.getId());
%>

<liferay-util:html-top>
	<link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/css/main.css", portlet.getTimestamp()) %>" rel="stylesheet" type="text/css" />
</liferay-util:html-top>

<%@ include file="/form_builder.jspf" %>