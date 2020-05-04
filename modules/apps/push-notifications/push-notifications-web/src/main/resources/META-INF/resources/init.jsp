<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.model.User" %><%@
page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.ResourceBundleLoader" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.push.notifications.constants.PushNotificationsActionKeys" %><%@
page import="com.liferay.push.notifications.model.PushNotificationsDevice" %><%@
page import="com.liferay.push.notifications.service.PushNotificationsDeviceLocalServiceUtil" %><%@
page import="com.liferay.push.notifications.web.internal.constants.PushNotificationsWebKeys" %><%@
page import="com.liferay.push.notifications.web.internal.security.permission.resource.PushNotificationsPermission" %><%@
page import="com.liferay.push.notifications.web.internal.util.PushNotificationsUtil" %><%@
page import="com.liferay.push.notifications.web.internal.util.ResourceBundleLoaderProvider" %>

<%@ page import="java.util.ResourceBundle" %>

<%@ page import="javax.portlet.PortletURL" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />