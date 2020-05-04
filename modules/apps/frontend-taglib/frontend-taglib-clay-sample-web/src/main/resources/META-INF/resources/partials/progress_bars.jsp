<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<blockquote>
	<p>Progress bar is a progress indicator used to show the completion percentage of a task.</p>
</blockquote>

<clay:progressbar
	maxValue="<%= 100 %>"
	minValue="<%= 0 %>"
	value="<%= 30 %>"
/>

<clay:progressbar
	maxValue="<%= 100 %>"
	minValue="<%= 0 %>"
	status="warning"
	value="<%= 70 %>"
/>

<clay:progressbar
	status="complete"
/>