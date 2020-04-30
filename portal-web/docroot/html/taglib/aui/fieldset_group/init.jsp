<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

@generated
--%>

<%@ include file="/html/taglib/taglib-init.jsp" %>

<%
java.lang.String markupView = GetterUtil.getString((java.lang.String)request.getAttribute("aui:fieldset-group:markupView"));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:fieldset-group:dynamicAttributes");
%>

<%@ include file="/html/taglib/aui/fieldset_group/init-ext.jspf" %>