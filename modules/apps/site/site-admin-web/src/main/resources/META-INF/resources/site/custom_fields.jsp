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

<liferay-expando:custom-attribute-list
	className="<%= Group.class.getName() %>"
	classPK="<%= (liveGroup != null) ? liveGroup.getGroupId() : 0 %>"
	editable="<%= true %>"
	label="<%= true %>"
/>