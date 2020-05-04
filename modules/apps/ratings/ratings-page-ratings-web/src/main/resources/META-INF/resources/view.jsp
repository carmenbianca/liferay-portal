<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String className = Layout.class.getName();
long classPK = layout.getPlid();

AssetEntry assetEntry = (AssetEntry)request.getAttribute(WebKeys.LAYOUT_ASSET_ENTRY);

if ((assetEntry != null) && layout.isTypeAssetDisplay()) {
	className = assetEntry.getClassName();
	classPK = assetEntry.getClassPK();
}
%>

<liferay-ratings:ratings
	className="<%= className %>"
	classPK="<%= classPK %>"
	inTrash="<%= false %>"
/>