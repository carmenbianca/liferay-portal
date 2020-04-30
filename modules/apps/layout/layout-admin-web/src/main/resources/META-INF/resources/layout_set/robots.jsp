<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
LayoutSet layoutSet = layoutsAdminDisplayContext.getSelLayoutSet();

String virtualHostname = layoutsAdminDisplayContext.getVirtualHostname();
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="robots"
/>

<c:choose>
	<c:when test="<%= Validator.isNotNull(virtualHostname) %>">
		<aui:input helpMessage="robots-txt-help" label="set-the-robots-txt" name='<%= "TypeSettingsProperties--" + layoutSet.isPrivateLayout() + "-robots.txt--" %>' placeholder="robots" type="textarea" value="<%= layoutsAdminDisplayContext.getRobots() %>" />
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="please-set-the-virtual-host-before-you-set-the-robots-txt" />
		</div>
	</c:otherwise>
</c:choose>