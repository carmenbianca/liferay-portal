<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Contact selContact = (Contact)request.getAttribute("user.selContact");
%>

<c:if test="<%= Validator.isNotNull(selContact.getSmsSn()) %>">
	<h3 class="icon-mobile-phone"><liferay-ui:message key="sms" /></h3>

	<ul class="property-list">
		<li><%= HtmlUtil.escape(selContact.getSmsSn()) %></li>
	</ul>
</c:if>