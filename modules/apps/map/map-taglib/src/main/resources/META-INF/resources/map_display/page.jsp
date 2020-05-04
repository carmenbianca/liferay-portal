<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/map_display/init.jsp" %>

<c:choose>
	<c:when test="<%= mapProvider != null %>">
		<div class="lfr-map" id="<%= name %>Map">

			<%
			mapProvider.include(request, PipingServletResponse.createPipingServletResponse(pageContext));
			%>

		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-danger">
			<%= LanguageUtil.get(resourceBundle, "a-map-should-be-shown-here") %>
		</div>
	</c:otherwise>
</c:choose>