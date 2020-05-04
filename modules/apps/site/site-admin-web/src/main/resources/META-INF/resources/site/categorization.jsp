<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Group liveGroup = (Group)request.getAttribute("site.liveGroup");
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="categorization"
/>

<aui:model-context bean="<%= liveGroup %>" model="<%= Group.class %>" />

<liferay-asset:asset-categories-error />

<liferay-asset:asset-tags-error />

<liferay-asset:asset-categories-selector
	className="<%= Group.class.getName() %>"
	classPK="<%= (liveGroup != null) ? liveGroup.getGroupId() : 0 %>"
/>

<liferay-asset:asset-tags-selector
	className="<%= Group.class.getName() %>"
	classPK="<%= (liveGroup != null) ? liveGroup.getGroupId() : 0 %>"
/>