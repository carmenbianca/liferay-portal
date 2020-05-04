<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/import/init.jsp" %>

<liferay-staging:process-list
	deleteMenu="<%= true %>"
	emptyResultsMessage="no-publication-processes-were-found"
	localTaskExecutorClassName="<%= BackgroundTaskExecutorNames.LAYOUT_IMPORT_BACKGROUND_TASK_EXECUTOR %>"
	mvcRenderCommandName="importLayoutsView"
	relaunchMenu="<%= false %>"
	resultRowSplitter="<%= new ExportImportResultRowSplitter() %>"
	summaryMenu="<%= false %>"
/>