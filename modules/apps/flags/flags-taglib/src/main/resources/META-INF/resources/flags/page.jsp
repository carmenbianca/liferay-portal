<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/flags/init.jsp" %>

<%
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-flags:flags:data");
String elementClasses = (String)request.getAttribute("liferay-flags:flags:elementClasses");
String id = StringUtil.randomId() + StringPool.UNDERLINE + "id";
String message = (String)request.getAttribute("liferay-flags:flags:message");
boolean onlyIcon = GetterUtil.getBoolean(request.getAttribute("liferay-flags:flags:onlyIcon"));
%>

<div class="taglib-flags <%= Validator.isNotNull(elementClasses) ? elementClasses : "" %>" id="<%= id %>">
	<c:choose>
		<c:when test="<%= onlyIcon %>">
			<clay:button
				disabled="<%= true %>"
				elementClasses="btn-outline-borderless btn-outline-secondary lfr-portal-tooltip"
				icon="flag-empty"
				monospaced="<%= true %>"
				size="sm"
				style="secondary"
				title="<%= message %>"
			/>
		</c:when>
		<c:otherwise>
			<clay:button
				disabled="<%= true %>"
				elementClasses="btn-outline-borderless btn-outline-secondary"
				icon="flag-empty"
				label="<%= message %>"
				size="sm"
				style="secondary"
			/>
		</c:otherwise>
	</c:choose>

	<react:component
		data="<%= data %>"
		module="flags/js/index.es"
	/>
</div>