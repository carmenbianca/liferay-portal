<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/init.jsp" %>

<%
OAuth2Application oAuth2Application = oAuth2AdminPortletDisplayContext.getOAuth2Application();

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

OAuth2Authorization oAuth2Authorization = (OAuth2Authorization)row.getObject();
%>

<c:if test="<%= oAuth2AdminPortletDisplayContext.hasRevokeTokenPermission(oAuth2Application) %>">
	<portlet:actionURL name="revokeOAuth2Authorization" var="revokeOAuth2AuthorizationURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="oAuth2AuthorizationId" value="<%= String.valueOf(oAuth2Authorization.getOAuth2AuthorizationId()) %>" />
	</portlet:actionURL>

	<aui:button onClick='<%= renderResponse.getNamespace() + "revokeOAuth2Authorization(" + oAuth2Authorization.getOAuth2AuthorizationId() + ")" %>' value="revoke" />
</c:if>