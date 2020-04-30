<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.model.Layout" %><%@
page import="com.liferay.portal.kernel.model.LayoutSet" %><%@
page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.util.LayoutDescription" %><%@
page import="com.liferay.site.navigation.site.map.web.internal.configuration.SiteNavigationSiteMapPortletInstanceConfiguration" %><%@
page import="com.liferay.site.navigation.site.map.web.internal.display.context.SiteNavigationSiteMapDisplayContext" %>

<%@ page import="java.util.List" %><%@
page import="java.util.Map" %><%@
page import="java.util.Objects" %>

<liferay-theme:defineObjects />

<%
SiteNavigationSiteMapDisplayContext siteNavigationSiteMapDisplayContext = new SiteNavigationSiteMapDisplayContext(request);

SiteNavigationSiteMapPortletInstanceConfiguration siteNavigationSiteMapPortletInstanceConfiguration = siteNavigationSiteMapDisplayContext.getSiteNavigationSiteMapPortletInstanceConfiguration();
%>

<%@ include file="/init-ext.jsp" %>