<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="<%= windowState.equals(WindowState.NORMAL) %>">
		<html:link page="/server_admin/view?windowState=maximized&portletMode=view&actionURL=0"><liferay-ui:message key="more" /></html:link> &raquo;
	</c:when>
	<c:otherwise>

		<%
		ServerDisplayContext serverDisplayContext = new ServerDisplayContext(request, renderResponse);
		%>

		<clay:navigation-bar
			inverted="<%= true %>"
			navigationItems="<%= serverDisplayContext.getServerNavigationItems() %>"
		/>

		<div class="<%= (tabs1.equals("log-levels") || tabs1.equals("properties")) ? StringPool.BLANK : "container-fluid-1280" %>">
			<c:choose>
				<c:when test='<%= tabs1.equals("log-levels") %>'>
					<liferay-util:include page="/log_levels.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:when test='<%= tabs1.equals("properties") %>'>
					<liferay-util:include page="/properties.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:when test='<%= tabs1.equals("data-migration") %>'>
					<liferay-util:include page="/data_migration.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:when test='<%= tabs1.equals("mail") %>'>
					<liferay-util:include page="/mail.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:when test='<%= tabs1.equals("external-services") %>'>
					<liferay-util:include page="/external_services.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:when test='<%= tabs1.equals("script") %>'>
					<liferay-util:include page="/script.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:when test='<%= tabs1.equals("shutdown") %>'>
					<liferay-util:include page="/shutdown.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:otherwise>
					<liferay-util:include page="/resources.jsp" servletContext="<%= application %>" />
				</c:otherwise>
			</c:choose>
		</div>
	</c:otherwise>
</c:choose>