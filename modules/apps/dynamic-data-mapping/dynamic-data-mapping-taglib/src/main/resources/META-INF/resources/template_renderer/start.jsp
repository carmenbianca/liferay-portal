<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/template_renderer/init.jsp" %>

<%
DDMTemplate portletDisplayDDMTemplate = (DDMTemplate)request.getAttribute("liferay-ddm:template-renderer:portletDisplayDDMTemplate");
%>

<c:if test="<%= portletDisplayDDMTemplate != null %>">
	<%= PortletDisplayTemplateUtil.renderDDMTemplate(request, response, portletDisplayDDMTemplate.getTemplateId(), entries, contextObjects) %>
</c:if>