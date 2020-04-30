<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
int backgroundTaskStatus = GetterUtil.getInteger(request.getAttribute("liferay-staging:process-status:backgroundTaskStatus"));
String backgroundTaskStatusLabel = GetterUtil.getString(request.getAttribute("liferay-staging:process-status:backgroundTaskStatusLabel"));

String clayClassPostfix = "info";

if (backgroundTaskStatus == BackgroundTaskConstants.STATUS_FAILED) {
	clayClassPostfix = "danger";
}
else if (backgroundTaskStatus == BackgroundTaskConstants.STATUS_IN_PROGRESS) {
	clayClassPostfix = "warning";
}
else if (backgroundTaskStatus == BackgroundTaskConstants.STATUS_SUCCESSFUL) {
	clayClassPostfix = "success";
}
%>