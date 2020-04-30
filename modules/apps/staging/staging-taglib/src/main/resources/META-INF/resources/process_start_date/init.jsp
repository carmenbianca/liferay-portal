<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BackgroundTask backgroundTask = (BackgroundTask)request.getAttribute("liferay-staging:process-start-date:backgroundTask");

boolean listView = GetterUtil.getBoolean(request.getAttribute("liferay-staging:process-start-date:listView"));

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.MEDIUM, FastDateFormatConstants.SHORT, locale, timeZone);
%>