<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
HttpServletRequest originalServletRequest = (HttpServletRequest)request.getAttribute(PortletLayoutTypeControllerWebKeys.ORIGINAL_HTTP_SERVLET_REQUEST);
%>

<c:choose>
	<c:when test="<%= themeDisplay.isStatePopUp() || themeDisplay.isWidget() || layoutTypePortlet.hasStateMax() %>">

		<%
		String ppid = ParamUtil.getString(request, "p_p_id");

		String templateId = null;
		String templateContent = null;
		String langType = null;

		if (themeDisplay.isStatePopUp() || themeDisplay.isWidget()) {
			templateId = theme.getThemeId() + LayoutTemplateConstants.STANDARD_SEPARATOR + "pop_up";
			templateContent = LayoutTemplateLocalServiceUtil.getContent("pop_up", true, theme.getThemeId());
			langType = LayoutTemplateLocalServiceUtil.getLangType("pop_up", true, theme.getThemeId());
		}
		else {
			ppid = StringUtil.split(layoutTypePortlet.getStateMax())[0];

			templateId = theme.getThemeId() + LayoutTemplateConstants.STANDARD_SEPARATOR + "max";
			templateContent = LayoutTemplateLocalServiceUtil.getContent("max", true, theme.getThemeId());
			langType = LayoutTemplateLocalServiceUtil.getLangType("max", true, theme.getThemeId());
		}

		if (Validator.isNotNull(templateContent)) {
			RuntimePageUtil.processTemplate(originalServletRequest, response, ppid, new StringTemplateResource(templateId, templateContent), langType);
		}
		%>

	</c:when>
	<c:otherwise>
		<style type="text/css">
			.master-layout-fragment .portlet-header {
				display: none;
			}
		</style>

		<%
		PortletLayoutDisplayContext portletLayoutDisplayContext = (PortletLayoutDisplayContext)request.getAttribute(PortletLayoutDisplayContext.class.getName());

		LayoutStructure layoutStructure = portletLayoutDisplayContext.getLayoutStructure();

		LayoutStructureItem layoutStructureItem = layoutStructure.getMainLayoutStructureItem();

		request.setAttribute("render_layout_structure.jsp-childrenItemIds", layoutStructureItem.getChildrenItemIds());
		%>

		<liferay-util:include page="/layout/view/render_layout_structure.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>

<liferay-ui:layout-common />