<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/process_status/init.jsp" %>

<span class="label label-<%= clayClassPostfix %> process-status" data-qa-id="processResult">
	<liferay-ui:message key="<%= backgroundTaskStatusLabel %>" />
</span>