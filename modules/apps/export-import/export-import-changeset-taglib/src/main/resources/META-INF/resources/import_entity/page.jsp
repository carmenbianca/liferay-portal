<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/import_entity/init.jsp" %>

<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, themeDisplay.getScopeGroup(), ActionKeys.EXPORT_IMPORT_PORTLET_INFO) %>">

	<%
	PortletURL portletURL = PortletURLFactoryUtil.create(request, ExportImportPortletKeys.EXPORT_IMPORT, PortletRequest.RENDER_PHASE);

	portletURL.setParameter("mvcPath", "/import_portlet.jsp");
	portletURL.setParameter("portletResource", ChangesetPortletKeys.CHANGESET);
	%>

	<liferay-frontend:add-menu-item
		title='<%= LanguageUtil.get(resourceBundle, "import") %>'
		url="<%= portletURL.toString() %>"
	/>
</c:if>