<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
LocalizedItemSelectorRendering localizedItemSelectorRendering = LocalizedItemSelectorRendering.get(liferayPortletRequest);

List<NavigationItem> navigationItems = localizedItemSelectorRendering.getNavigationItems();
%>

<c:choose>
	<c:when test="<%= navigationItems.isEmpty() %>">

		<%
		if (_log.isWarnEnabled()) {
			String[] criteria = ParamUtil.getParameterValues(renderRequest, "criteria");

			_log.warn("No item selector views found for " + StringUtil.merge(criteria, StringPool.COMMA_AND_SPACE));
		}
		%>

		<div class="alert alert-info">
			<%= LanguageUtil.get(resourceBundle, "selection-is-not-available") %>
		</div>
	</c:when>
	<c:otherwise>
		<c:if test="<%= navigationItems.size() > 1 %>">
			<clay:navigation-bar
				elementClasses="border-bottom"
				inverted="<%= false %>"
				navigationItems="<%= navigationItems %>"
			/>
		</c:if>

		<%
		boolean showGroupSelector = ParamUtil.getBoolean(request, "showGroupSelector");
		%>

		<c:choose>
			<c:when test="<%= showGroupSelector %>">
				<liferay-item-selector:group-selector />
			</c:when>
			<c:otherwise>

				<%
				ItemSelectorViewRenderer itemSelectorViewRenderer = localizedItemSelectorRendering.getSelectedItemSelectorViewRenderer();

				itemSelectorViewRenderer.renderHTML(pageContext);
				%>

			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>

<%!
private static Log _log = LogFactoryUtil.getLog("com_liferay_item_selector_web.view_jsp");
%>