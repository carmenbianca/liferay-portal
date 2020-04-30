<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/layout/edit/init.jsp" %>

<%
String selectedPortletId = StringPool.BLANK;

if (selLayout != null) {
	selectedPortletId = GetterUtil.getString(selLayout.getTypeSettingsProperty("fullPageApplicationPortlet"));
}
%>

<aui:select label='<%= LanguageUtil.get(resourceBundle, "full-page-application") %>' name="TypeSettingsProperties--fullPageApplicationPortlet--">

	<%
	List<Portlet> portlets = (List<Portlet>)request.getAttribute(FullPageApplicationLayoutTypeControllerWebKeys.FULL_PAGE_APPLICATION_PORTLETS);

	for (Portlet portlet : portlets) {
	%>

		<aui:option label="<%= PortalUtil.getPortletLongTitle(portlet, application, locale) %>" selected="<%= Objects.equals(selectedPortletId, portlet.getPortletId()) %>" value="<%= portlet.getPortletId() %>" />

	<%
	}
	%>

</aui:select>