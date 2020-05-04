<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SiteNavigationMenuItem siteNavigationMenuItem = (SiteNavigationMenuItem)request.getAttribute(SiteNavigationWebKeys.SITE_NAVIGATION_MENU_ITEM);

String url = StringPool.BLANK;

if (siteNavigationMenuItem != null) {
	UnicodeProperties typeSettingsProperties = new UnicodeProperties();

	typeSettingsProperties.fastLoad(siteNavigationMenuItem.getTypeSettings());

	url = typeSettingsProperties.get("url");
}
%>

<aui:input autoFocus="<%= true %>" label="name" localized="<%= true %>" maxlength='<%= ModelHintsUtil.getMaxLength(SiteNavigationMenuItem.class.getName(), "name") %>' name="name" placeholder="name" type="text" value='<%= SiteNavigationMenuItemUtil.getSiteNavigationMenuItemXML(siteNavigationMenuItem, "name") %>'>
	<aui:validator name="required" />
</aui:input>

<aui:input label="url" name="TypeSettingsProperties--url--" placeholder="http://" value="<%= url %>">
	<aui:validator name="required" />

	<aui:validator name="url" />
</aui:input>