<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%@ page import="com.liferay.portal.javadoc.JavadocUtil" %><%@
page import="com.liferay.portal.kernel.javadoc.JavadocClass" %><%@
page import="com.liferay.portal.kernel.javadoc.JavadocManagerUtil" %><%@
page import="com.liferay.portal.kernel.javadoc.JavadocMethod" %><%@
page import="com.liferay.portal.kernel.jsonwebservice.JSONWebServiceActionMapping" %><%@
page import="com.liferay.portal.kernel.jsonwebservice.JSONWebServiceActionsManagerUtil" %><%@
page import="com.liferay.portal.kernel.util.MethodParameter" %>

<%@ page import="java.io.File" %>

<%@ page import="java.lang.reflect.Method" %>

<%
String jsonWSPath = themeDisplay.getPathContext() + "/api/jsonws";

String contextName = ParamUtil.getString(request, "contextName");

String jsonWSContextPath = jsonWSPath + "?contextName=" + contextName;
%>