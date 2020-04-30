<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/select_layout/init.jsp" %>

<%
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-layout:select-layout:data");
%>

<div>
	<react:component
		data="<%= data %>"
		module="select_layout/js/SelectLayout.es"
	/>
</div>