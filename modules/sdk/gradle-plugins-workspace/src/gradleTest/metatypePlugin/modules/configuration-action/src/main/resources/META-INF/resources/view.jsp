<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean doConfigure = Validator.isNull(fontFamily) && Validator.isNull(fontColor) && (Validator.isNull(fontSize) || fontSize.equals("0"));
%>

<c:choose>
	<c:when test="<%= doConfigure %>">
		<liferay-ui:message key="blade_configurationaction_portlet_BladeMessagePortlet.no-config" />
	</c:when>
	<c:otherwise>
		<p style="color: <%= fontColor %>; font-family: <%= fontFamily %>; font-size: <%= fontSize %>;">
			<liferay-ui:message key="blade_configurationaction_portlet_BladeMessagePortlet.caption" />
		</p>
	</c:otherwise>
</c:choose>