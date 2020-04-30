<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-frontend:diff-version-comparator:data");
%>

<div>
	<react:component
		data="<%= data %>"
		module="diff_version_comparator/index"
	/>
</div>