<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:if test="<%= !portletName.equals(PortletKeys.FRIENDS_DIRECTORY) %>">
	<clay:navigation-bar
		inverted="<%= false %>"
		navigationItems='<%=
			new JSPNavigationItemList(pageContext) {
				{
					PortletURL portletURL = renderResponse.createRenderURL();

					portletURL.setParameter("mvcRenderCommandName", "/directory/view");
					portletURL.setParameter("tabs1", "users");

					add(
						navigationItem -> {
							navigationItem.setActive(tabs1.equals("users"));
							navigationItem.setHref(portletURL);
							navigationItem.setLabel(LanguageUtil.get(request, "users"));
						});

					portletURL.setParameter("tabs1", "organizations");

					add(
						navigationItem -> {
							navigationItem.setActive(tabs1.equals("organizations"));
							navigationItem.setHref(portletURL);
							navigationItem.setLabel(LanguageUtil.get(request, "organizations"));
						});

					portletURL.setParameter("tabs1", "user-groups");

					add(
						navigationItem -> {
							navigationItem.setActive(tabs1.equals("user-groups"));
							navigationItem.setHref(portletURL);
							navigationItem.setLabel(LanguageUtil.get(request, "user-groups"));
						});
				}
			}
		%>'
	/>
</c:if>