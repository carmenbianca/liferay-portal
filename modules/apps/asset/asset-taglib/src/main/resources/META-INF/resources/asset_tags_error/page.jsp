<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/asset_tags_error/init.jsp" %>

<liferay-ui:error exception="<%= AssetTagException.class %>">

	<%
	AssetTagException ate = (AssetTagException)errorException;
	%>

	<c:choose>
		<c:when test="<%= ate.getType() == AssetTagException.AT_LEAST_ONE_TAG %>">
			<liferay-ui:message key="please-enter-at-least-one-tag" />
		</c:when>
		<c:when test="<%= ate.getType() == AssetTagException.INVALID_CHARACTER %>">
			<liferay-ui:message key="one-or-more-tags-contains-invalid-characters" />
		</c:when>
	</c:choose>
</liferay-ui:error>