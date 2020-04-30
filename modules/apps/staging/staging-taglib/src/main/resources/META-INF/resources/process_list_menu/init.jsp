<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BackgroundTask backgroundTask = (BackgroundTask)request.getAttribute("liferay-staging:process-list-menu:backgroundTask");
boolean deleteMenu = GetterUtil.getBoolean(request.getAttribute("liferay-staging:process-list-menu:deleteMenu"));
boolean localPublishing = GetterUtil.getBoolean(request.getAttribute("liferay-staging:process-list-menu:localPublishing"));
boolean relaunchMenu = GetterUtil.getBoolean(request.getAttribute("liferay-staging:process-list-menu:relaunchMenu"));
boolean summaryMenu = GetterUtil.getBoolean(request.getAttribute("liferay-staging:process-list-menu:summaryMenu"));

Date completionDate = backgroundTask.getCompletionDate();

String deleteLabel = LanguageUtil.get(request, ((completionDate != null) && completionDate.before(new Date())) ? "clear" : "cancel");
%>