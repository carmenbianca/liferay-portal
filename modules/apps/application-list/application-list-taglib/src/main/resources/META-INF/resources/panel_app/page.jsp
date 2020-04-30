<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/panel_app/init.jsp" %>

<%
boolean active = GetterUtil.getBoolean(request.getAttribute("liferay-application-list:panel-app:active"));
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-application-list:panel-app:data");
String id = (String)request.getAttribute("liferay-application-list:panel-app:id");
String label = (String)request.getAttribute("liferay-application-list:panel-app:label");
int notificationsCount = GetterUtil.getInteger(request.getAttribute("liferay-application-list:panel-app:notificationsCount"));
String url = (String)request.getAttribute("liferay-application-list:panel-app:url");
%>

<c:if test="<%= Validator.isNotNull(url) %>">
	<li class="<%= active ? "active" : StringPool.BLANK %>" role="presentation">
		<aui:a ariaRole="menuitem" data="<%= data %>" href="<%= url %>" id="<%= id %>">
			<%= label %>

			<c:if test="<%= notificationsCount > 0 %>">
				<span class="badge badge-danger float-right">
					<span class="badge-item badge-item-expand"><%= notificationsCount %></span>
				</span>
			</c:if>
		</aui:a>
	</li>
</c:if>