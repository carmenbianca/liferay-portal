<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %><%@
page import="com.liferay.portal.kernel.servlet.taglib.aui.ValidatorTag" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.taglib.util.InlineUtil" %>

<%
String action = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-frontend:edit-form:action"));
List<String> checkboxNames = (List<String>)request.getAttribute("LIFERAY_SHARED_aui:form:checkboxNames");
String cssClass = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-frontend:edit-form:cssClass"));
boolean fluid = GetterUtil.getBoolean(String.valueOf(request.getAttribute("liferay-frontend:edit-form:fluid")));
boolean inlineLabels = GetterUtil.getBoolean(String.valueOf(request.getAttribute("liferay-frontend:edit-form:inlineLabels")));
String method = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-frontend:edit-form:method"));
String name = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-frontend:edit-form:name"));
String onSubmit = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-frontend:edit-form:onSubmit"));
boolean validateOnBlur = GetterUtil.getBoolean(String.valueOf(request.getAttribute("liferay-frontend:edit-form:validateOnBlur")));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("liferay-frontend:edit-form:dynamicAttributes");
Map<String, List<ValidatorTag>> validatorTagsMap = (Map<String, List<ValidatorTag>>)request.getAttribute("LIFERAY_SHARED_aui:form:validatorTagsMap");
%>