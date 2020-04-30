<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-staging:process-list
	emptyResultsMessage="no-publication-processes-were-found"
	localTaskExecutorClassName="<%= BackgroundTaskExecutorNames.LAYOUT_STAGING_BACKGROUND_TASK_EXECUTOR %>"
	mvcRenderCommandName="publishLayoutsView"
	remoteTaskExecutorClassName="<%= BackgroundTaskExecutorNames.LAYOUT_REMOTE_STAGING_BACKGROUND_TASK_EXECUTOR %>"
	resultRowSplitter="<%= new PublishResultRowSplitter() %>"
/>