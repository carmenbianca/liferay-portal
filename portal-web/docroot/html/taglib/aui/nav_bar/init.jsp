<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

@generated
--%>

<%@ include file="/html/taglib/taglib-init.jsp" %>

<%
java.lang.String cssClass = GetterUtil.getString((java.lang.String)request.getAttribute("aui:nav-bar:cssClass"));
java.util.Map data = (java.util.Map)request.getAttribute("aui:nav-bar:data");
java.lang.String id = GetterUtil.getString((java.lang.String)request.getAttribute("aui:nav-bar:id"));
java.lang.String markupView = GetterUtil.getString((java.lang.String)request.getAttribute("aui:nav-bar:markupView"));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:nav-bar:dynamicAttributes");
%>

<%@ include file="/html/taglib/aui/nav_bar/init-ext.jspf" %>