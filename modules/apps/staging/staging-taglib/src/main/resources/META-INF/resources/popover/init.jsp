<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String id = GetterUtil.getString(request.getAttribute("liferay-staging:popover:id"));
String textKey = GetterUtil.getString(request.getAttribute("liferay-staging:popover:text"));
String titleKey = GetterUtil.getString(request.getAttribute("liferay-staging:popover:title"));

String domId = liferayPortletResponse.getNamespace() + id;
String text = Validator.isNotNull(textKey) ? LanguageUtil.get(request, textKey) : "";
String title = LanguageUtil.get(request, titleKey);
%>