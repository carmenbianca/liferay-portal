<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String navigationName = ParamUtil.getString(request, "navigationName");
%>

<c:if test="<%= Validator.isNotNull(navigationName) %>">
	<aui:nav-bar markupView="lexicon">
		<aui:nav cssClass="navbar-nav">
			<aui:nav-item label="<%= navigationName %>" selected="<%= true %>" />
		</aui:nav>
	</aui:nav-bar>
</c:if>