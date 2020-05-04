<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1");

String redirect = ParamUtil.getString(request, "redirect");
String returnToFullPageURL = ParamUtil.getString(request, "returnToFullPageURL");

PortalUtil.addPortletBreadcrumbEntry(request, PortalUtil.getPortletTitle(renderResponse), null);
PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "configuration"), null);
PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, tabs1), currentURL);
%>

<clay:navigation-bar
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				if (selPortlet.getConfigurationActionInstance() != null) {
				add(
						navigationItem -> {
							navigationItem.setActive(tabs1.equals("setup"));
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcPath", "/edit_configuration.jsp", "redirect", redirect, "returnToFullPageURL", returnToFullPageURL, "portletConfiguration", Boolean.TRUE.toString(), "portletResource", portletResource);
							navigationItem.setLabel(LanguageUtil.get(request, "setup"));
						});
				}

				if (selPortlet.hasMultipleMimeTypes()) {
					add(
						navigationItem -> {
							navigationItem.setActive(tabs1.equals("supported-clients"));
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcPath", "/edit_supported_clients.jsp", "redirect", redirect, "returnToFullPageURL", returnToFullPageURL, "portletConfiguration", Boolean.TRUE.toString(), "portletResource", portletResource);
							navigationItem.setLabel(LanguageUtil.get(request, "supported-clients"));
						});
				}

				Set<PublicRenderParameter> publicRenderParameters = selPortlet.getPublicRenderParameters();

				if (!publicRenderParameters.isEmpty()) {
					add(
						navigationItem -> {
							navigationItem.setActive(tabs1.equals("communication"));
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcPath", "/edit_public_render_parameters.jsp", "redirect", redirect, "returnToFullPageURL", returnToFullPageURL, "portletConfiguration", Boolean.TRUE.toString(), "portletResource", portletResource);
							navigationItem.setLabel(LanguageUtil.get(request, "communication"));
						});
				}

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("sharing"));
						navigationItem.setHref(renderResponse.createRenderURL(), "mvcPath", "/edit_sharing.jsp", "redirect", redirect, "returnToFullPageURL", returnToFullPageURL, "portletConfiguration", Boolean.TRUE.toString(), "portletResource", portletResource);
						navigationItem.setLabel(LanguageUtil.get(request, "sharing"));
					});

				if (selPortlet.isScopeable()) {
					add(
						navigationItem -> {
							navigationItem.setActive(tabs1.equals("scope"));
							navigationItem.setHref(renderResponse.createRenderURL(), "mvcPath", "/edit_scope.jsp", "redirect", redirect, "returnToFullPageURL", returnToFullPageURL, "portletConfiguration", Boolean.TRUE.toString(), "portletResource", portletResource);
							navigationItem.setLabel(LanguageUtil.get(request, "scope"));
						});
				}
			}
		}
	%>'
/>