<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<blockquote>
	<p>A navigation bar, navbar, is an horizontal bar that provides several access points to different parts of a system.</p>
</blockquote>

<h3>NAVIGATION BARS USING DISPLAY CONTEXT</h3>

<clay:navigation-bar
	navigationItems="<%= navigationBarsDisplayContext.getNavigationItems() %>"
/>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= navigationBarsDisplayContext.getNavigationItems() %>"
/>

<h3>NAVIGATION BAR USING CONTRIBUTOR</h3>

<clay:navigation-bar
	contributorKey="SampleNavigationBar"
	navigationItems="<%= navigationBarsDisplayContext.getNavigationItems() %>"
/>