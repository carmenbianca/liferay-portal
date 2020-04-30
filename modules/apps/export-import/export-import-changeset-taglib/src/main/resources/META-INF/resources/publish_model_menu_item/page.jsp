<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/publish_model_menu_item/init.jsp" %>

<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, themeDisplay.getScopeGroup(), ActionKeys.EXPORT_IMPORT_PORTLET_INFO) && showMenuItem %>">

	<%
	PortletURL portletURL = PortletURLFactoryUtil.create(request, ChangesetPortletKeys.CHANGESET, PortletRequest.ACTION_PHASE);

	portletURL.setParameter(ActionRequest.ACTION_NAME, "exportImportChangeset");
	portletURL.setParameter("mvcRenderCommandName", "exportImportChangeset");
	portletURL.setParameter("cmd", Constants.PUBLISH);
	portletURL.setParameter("backURL", currentURL);
	portletURL.setParameter("changesetUuid", changesetUuid);
	portletURL.setParameter("portletId", portletDisplay.getId());
	%>

	<liferay-ui:icon
		message="publish-to-live"
		url="<%= portletURL.toString() %>"
	/>
</c:if>