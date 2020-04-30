<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
String id = GetterUtil.getString((String)request.getAttribute("liferay-ui:icon-menu:id"));
boolean scroll = GetterUtil.getBoolean(request.getAttribute("liferay-ui:icon-menu:scroll"));
%>

		</ul>
	<c:if test="<%= scroll %>">
		</div>
	</c:if>
</div>

<aui:script use="liferay-menu">
	Liferay.Menu.handleFocus('#<%= id %>menu');
</aui:script>