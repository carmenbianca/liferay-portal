<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="<%= journalDisplayContext.useDataEngineEditor() %>">
		<liferay-util:include page="/edit_ddm_structure_data_layout_builder.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/edit_ddm_structure_form_builder.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>