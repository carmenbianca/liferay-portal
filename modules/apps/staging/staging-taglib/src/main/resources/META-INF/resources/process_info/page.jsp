<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/process_info/init.jsp" %>

<div class="container text-secondary">
	<div class="row">
		<div class="col-sm">
			<liferay-staging:process-title
				backgroundTask="<%= backgroundTask %>"
				listView="<%= false %>"
			/>
		</div>
	</div>

	<div class="row">
		<div class="col-sm"><%= HtmlUtil.escape(userName) %></div>
		<div class="col-sm">
			<liferay-staging:process-date
				date="<%= backgroundTask.getCreateDate() %>"
				labelKey="start-date"
				listView="<%= false %>"
			/>
		</div>

		<div class="col-sm">
			<liferay-staging:process-date
				date="<%= backgroundTask.getCompletionDate() %>"
				labelKey="completion-date"
				listView="<%= false %>"
			/>
		</div>
	</div>

	<div class="row">
		<div class="col">
			<liferay-staging:process-in-progress
				backgroundTask="<%= backgroundTask %>"
				listView="<%= false %>"
			/>
		</div>
	</div>

	<div class="row">
		<div class="col">
			<liferay-staging:process-status
				backgroundTaskStatus="<%= backgroundTask.getStatus() %>"
				backgroundTaskStatusLabel="<%= backgroundTask.getStatusLabel() %>"
			/>
		</div>
	</div>
</div>