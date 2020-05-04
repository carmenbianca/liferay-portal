<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Date date = (Date)request.getAttribute("liferay-staging:process-date:date");
String labelKey = GetterUtil.getString(request.getAttribute("liferay-staging:process-date:labelKey"));
boolean listView = GetterUtil.getBoolean(request.getAttribute("liferay-staging:process-date:listView"));

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.MEDIUM, FastDateFormatConstants.SHORT, locale, timeZone);
%>