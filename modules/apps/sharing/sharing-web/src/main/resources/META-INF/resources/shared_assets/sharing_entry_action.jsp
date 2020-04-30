<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/shared_assets/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

SharingEntry sharingEntry = (SharingEntry)row.getObject();

SharedAssetsViewDisplayContext sharedAssetsViewDisplayContext = (SharedAssetsViewDisplayContext)renderRequest.getAttribute(SharedAssetsViewDisplayContext.class.getName());
%>

<liferay-ui:menu
	menu="<%= sharedAssetsViewDisplayContext.getSharingEntryMenu(sharingEntry) %>"
/>