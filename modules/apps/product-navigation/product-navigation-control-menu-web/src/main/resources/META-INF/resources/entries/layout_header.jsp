<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
LayoutTypeController layoutTypeController = LayoutTypeControllerTracker.getLayoutTypeController(layout.getType());

ResourceBundle layoutTypeResourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, layoutTypeController.getClass());

String headerTitle = HtmlUtil.escape(layout.getName(locale));

String layoutFriendlyURL = layout.getFriendlyURL();

String portletId = ParamUtil.getString(request, "p_p_id");

if (Validator.isNotNull(portletId) && layout.isSystem() && !layout.isTypeControlPanel() && layoutFriendlyURL.equals(PropsValues.CONTROL_PANEL_LAYOUT_FRIENDLY_URL)) {
	headerTitle = PortalUtil.getPortletTitle(portletId, locale);
}
%>

<li class="align-items-center control-menu-nav-item control-menu-nav-item-content">
	<span class="control-menu-level-1-heading text-truncate" data-qa-id="headerTitle"><%= headerTitle %></span>&nbsp;<span class="text-muted text-truncate">(<%= LanguageUtil.get(request, layoutTypeResourceBundle, "layout.types." + layout.getType()) %>)</span>
</li>