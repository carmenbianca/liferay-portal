<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-asset:asset-display
	abstractLength="<%= assetDisplayDisplayContext.getAbstractLength() %>"
	className="<%= assetDisplayDisplayContext.getClassName() %>"
	classPK="<%= assetDisplayDisplayContext.getClassPK() %>"
	showComments="<%= assetDisplayDisplayContext.isShowComments() %>"
	showExtraInfo="<%= assetDisplayDisplayContext.isShowExtraInfo() %>"
	showHeader="<%= assetDisplayDisplayContext.isShowHeader() %>"
	template="<%= assetDisplayDisplayContext.getTemplate() %>"
	viewURL="<%= assetDisplayDisplayContext.getViewURL() %>"
/>