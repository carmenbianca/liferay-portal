<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String navigation = ParamUtil.getString(request, "navigation", "redirects");
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(!navigation.equals("404-urls"));
						navigationItem.setHref(renderResponse.createRenderURL());
						navigationItem.setLabel(LanguageUtil.get(request, "redirects"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(navigation.equals("404-urls"));
						navigationItem.setHref(renderResponse.createRenderURL(), "navigation", "404-urls");
						navigationItem.setLabel(LanguageUtil.format(request, "x-urls", HttpServletResponse.SC_NOT_FOUND, false));
					});
			}
		}
	%>'
/>

<c:choose>
	<c:when test='<%= navigation.equals("404-urls") %>'>
		<liferay-util:include page="/view_redirect_not_found_entries.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/view_redirect_entries.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>