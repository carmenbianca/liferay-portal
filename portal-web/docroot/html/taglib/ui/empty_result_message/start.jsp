<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/empty_result_message/init.jsp" %>

<%
String cssClass = (String)request.getAttribute("liferay-ui:empty-result-message:cssClass");
String message = GetterUtil.getString((String)request.getAttribute("liferay-ui:empty-result-message:message"));
%>

<c:choose>
	<c:when test="<%= compact %>">
		<p class="text-muted">
			<liferay-ui:message key="<%= message %>" />
		</p>
	</c:when>
	<c:otherwise>
		<div class="sheet taglib-empty-result-message">
			<div class="<%= cssClass %>"></div>

			<c:if test="<%= Validator.isNotNull(message) %>">
				<div class="sheet-text text-center">
					<liferay-ui:message key="<%= message %>" />
				</div>
			</c:if>
	</c:otherwise>
</c:choose>