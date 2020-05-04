<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BackgroundTask backgroundTask = (BackgroundTask)request.getAttribute("backgroundTask");

BackgroundTaskStatus backgroundTaskStatus = BackgroundTaskStatusRegistryUtil.getBackgroundTaskStatus(backgroundTask.getBackgroundTaskId());
%>

<c:if test="<%= backgroundTaskStatus != null %>">

	<%
	int percentage = 0;

	long applicationDataCounter = GetterUtil.getLong(backgroundTaskStatus.getAttribute("applicationDataCounter"));
	long applicationDataTotal = GetterUtil.getLong(backgroundTaskStatus.getAttribute("applicationDataTotal"));

	percentage = Math.round((float)applicationDataCounter / applicationDataTotal * 100);
	%>

	<clay:progressbar
		maxValue="<%= 100 %>"
		minValue="<%= 0 %>"
		value="<%= percentage %>"
	/>
</c:if>