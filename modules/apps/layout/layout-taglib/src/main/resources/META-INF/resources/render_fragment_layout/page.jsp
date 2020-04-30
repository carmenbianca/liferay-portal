<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/render_fragment_layout/init.jsp" %>

<%
LayoutStructure layoutStructure = (LayoutStructure)request.getAttribute("liferay-layout:render-fragment-layout:layoutStructure");
%>

<div class="layout-content portlet-layout" id="main-content" role="main">

	<%
	try {
		request.setAttribute(WebKeys.SHOW_PORTLET_TOPPER, Boolean.TRUE);

		LayoutStructureItem layoutStructureItem = layoutStructure.getMainLayoutStructureItem();

		request.setAttribute("render_layout_structure.jsp-childrenItemIds", layoutStructureItem.getChildrenItemIds());

		RenderFragmentLayoutDisplayContext renderFragmentLayoutDisplayContext = (RenderFragmentLayoutDisplayContext)request.getAttribute("liferay-layout:render-fragment-layout:renderFragmentLayoutDisplayContext");
	%>

		<%= renderFragmentLayoutDisplayContext.getPortletPaths() %>

		<liferay-util:include page="/render_fragment_layout/render_layout_structure.jsp" servletContext="<%= application %>" />

	<%
	}
	finally {
		request.removeAttribute(WebKeys.SHOW_PORTLET_TOPPER);
	}
	%>

</div>