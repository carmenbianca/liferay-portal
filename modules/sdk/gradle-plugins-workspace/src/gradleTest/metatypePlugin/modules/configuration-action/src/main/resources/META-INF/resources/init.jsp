<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.blade.configuration.action.MessageDisplayConfiguration" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
MessageDisplayConfiguration messageDisplayConfiguration = (MessageDisplayConfiguration)renderRequest.getAttribute(MessageDisplayConfiguration.class.getName());

String fontColor = StringPool.BLANK;
String fontFamily = StringPool.BLANK;
String fontSize = StringPool.BLANK;

if (messageDisplayConfiguration != null) {
	fontColor = portletPreferences.getValue("fontColor", messageDisplayConfiguration.fontColor());
	fontFamily = portletPreferences.getValue("fontFamily", messageDisplayConfiguration.fontFamily());
	fontSize = portletPreferences.getValue("fontSize", String.valueOf(messageDisplayConfiguration.fontSize()));
}
%>