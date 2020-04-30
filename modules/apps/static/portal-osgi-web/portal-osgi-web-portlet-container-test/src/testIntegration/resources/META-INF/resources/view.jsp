<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.osgi.web.portlet.container.test.TestPortlet" %>

<%@ page import="java.util.Collections" %><%@
page import="java.util.Map" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"testRuntimePortletId", "testRuntimePortletId"
).build();

String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", StringPool.BLANK));
long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), scopeGroupId);
%>

<liferay-ddm:template-renderer
	className="<%= TestPortlet.class.getName() %>"
	contextObjects="<%= contextObjects %>"
	displayStyle="<%= displayStyle %>"
	displayStyleGroupId="<%= displayStyleGroupId %>"
	entries="<%= Collections.emptyList() %>"
>
	This is the default content in case of failure.
</liferay-ddm:template-renderer>