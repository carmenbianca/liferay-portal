<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="<%= Validator.isNull(message) %>">

		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="alert alert-info text-center">
			<div>
				<liferay-ui:message key="this-application-is-not-visible-to-users" />
			</div>

			<div>
				<aui:a href="javascript:;" onClick="<%= portletDisplay.getURLConfigurationJS() %>"><liferay-ui:message key="add-some-content-to-make-it-visible" /></aui:a>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<%= message %>
	</c:otherwise>
</c:choose>