<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/export_entity/init.jsp" %>

<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, themeDisplay.getScopeGroup(), ActionKeys.EXPORT_IMPORT_PORTLET_INFO) && showMenuItem %>">

	<%
	PortletURL portletURL = PortletURLFactoryUtil.create(request, ChangesetPortletKeys.CHANGESET, PortletRequest.ACTION_PHASE);

	portletURL.setParameter(ActionRequest.ACTION_NAME, "exportImportEntity");
	portletURL.setParameter("mvcRenderCommandName", "exportImportEntity");
	portletURL.setParameter("cmd", Constants.EXPORT);
	portletURL.setParameter("classNameId", String.valueOf(classNameId));
	portletURL.setParameter("groupId", String.valueOf(exportEntityGroupId));
	portletURL.setParameter("uuid", uuid);
	portletURL.setParameter("portletId", portletDisplay.getId());
	%>

	<liferay-ui:icon
		message="export"
		url="<%= portletURL.toString() %>"
	/>
</c:if>