<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String className = ParamUtil.getString(request, "className", Layout.class.getName());
long classPK = ParamUtil.getLong(request, "classPK", layout.getPlid());

AssetEntry assetEntry = (AssetEntry)request.getAttribute(WebKeys.LAYOUT_ASSET_ENTRY);

if ((assetEntry != null) && layout.isTypeAssetDisplay()) {
	className = assetEntry.getClassName();
	classPK = assetEntry.getClassPK();
}
%>

<c:if test="<%= LayoutPermissionUtil.contains(permissionChecker, layout, ActionKeys.VIEW) %>">
	<liferay-comment:discussion
		className="<%= className %>"
		classPK="<%= classPK %>"
		formName="fm"
		redirect="<%= currentURL %>"
		userId="<%= user.getUserId() %>"
	/>
</c:if>