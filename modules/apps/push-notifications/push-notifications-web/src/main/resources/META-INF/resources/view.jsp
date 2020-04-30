<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "devices");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("tabs1", tabs1);
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("devices"));
						navigationItem.setHref(renderResponse.createRenderURL());
						navigationItem.setLabel(LanguageUtil.get(request, "devices"));
					});
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("test"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "test");
						navigationItem.setLabel(LanguageUtil.get(request, "test"));
					});

			}
		}
	%>'
/>

<div class="container-fluid-1280">
	<c:choose>
		<c:when test='<%= tabs1.equals("test") %>'>
			<%@ include file="/test.jspf" %>
		</c:when>
		<c:otherwise>
			<%@ include file="/devices.jspf" %>
		</c:otherwise>
	</c:choose>
</div>