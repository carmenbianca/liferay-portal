<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BackgroundTask backgroundTask = (BackgroundTask)request.getAttribute("liferay-staging:process-duration:backgroundTask");
boolean listView = GetterUtil.getBoolean(request.getAttribute("liferay-staging:process-duration:listView"));

Date endDate = backgroundTask.getCompletionDate();
Date startDate = backgroundTask.getCreateDate();

long duration = 0;

if ((endDate != null) && (startDate != null) && (startDate.getTime() < endDate.getTime())) {
	duration = endDate.getTime() - startDate.getTime();
}

String timeDescription = LanguageUtil.getTimeDescription(themeDisplay.getLocale(), duration, true);
%>