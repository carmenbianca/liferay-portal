<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(renderRequest, "tabs1", "assigned-to-me");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/view.jsp");
portletURL.setParameter("tabs1", tabs1);
%>

<clay:navigation-bar
	inverted="<%= layout.isTypeControlPanel() %>"
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("assigned-to-me"));
						navigationItem.setHref(renderResponse.createRenderURL(), "mvcPath", "/view.jsp", "tabs1", "assigned-to-me");
						navigationItem.setLabel(LanguageUtil.get(request, "assigned-to-me"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("assigned-to-my-roles"));
						navigationItem.setHref(renderResponse.createRenderURL(), "mvcPath", "/view.jsp", "tabs1", "assigned-to-my-roles");
						navigationItem.setLabel(LanguageUtil.get(request, "assigned-to-my-roles"));
					});
			}
		}
	%>'
/>

<clay:management-toolbar
	clearResultsURL="<%= workflowTaskDisplayContext.getClearResultsURL() %>"
	filterDropdownItems="<%= workflowTaskDisplayContext.getFilterOptions() %>"
	itemsTotal="<%= workflowTaskDisplayContext.getTotalItems() %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchActionURL="<%= workflowTaskDisplayContext.getSearchURL() %>"
	searchContainerId="workflowTasks"
	searchFormName="fm1"
	selectable="<%= false %>"
	sortingOrder="<%= workflowTaskDisplayContext.getOrderByType() %>"
	sortingURL="<%= workflowTaskDisplayContext.getSortingURL() %>"
	viewTypeItems="<%= workflowTaskDisplayContext.getViewTypes() %>"
/>