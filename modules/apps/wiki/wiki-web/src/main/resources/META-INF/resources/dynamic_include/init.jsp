<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.JavaConstants" %><%@
page import="com.liferay.wiki.configuration.WikiGroupServiceConfiguration" %><%@
page import="com.liferay.wiki.constants.WikiWebKeys" %><%@
page import="com.liferay.wiki.model.WikiNode" %><%@
page import="com.liferay.wiki.web.internal.display.context.util.WikiRequestHelper" %><%@
page import="com.liferay.wiki.web.internal.display.context.util.WikiURLHelper" %><%@
page import="com.liferay.wiki.web.internal.util.WikiWebComponentProvider" %>

<%@ page import="javax.portlet.PortletResponse" %><%@
page import="javax.portlet.PortletURL" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />