<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<blockquote>
	<p>Tables are lists of properties of items arranged as rows and columns. Each table cell can use a custom renderer so that its data can be displayed in the best way.</p>
</blockquote>

<clay:table
	contributorKey="SampleTable"
	dataSourceKey="SampleTable"
	tableSchemaContributorKey="SampleTable"
/>