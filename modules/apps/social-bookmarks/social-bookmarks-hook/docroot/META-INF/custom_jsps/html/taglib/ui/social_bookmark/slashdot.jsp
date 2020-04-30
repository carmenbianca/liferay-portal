<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/social_bookmark/init.jsp" %>

<%
String slashdotDisplayStyle = StringPool.BLANK;

if (displayStyle.equals("vertical")) {
	slashdotDisplayStyle = "slashdot_badge_style='v0'";
}
%>

<aui:script>
	slashdot_title='<%= HtmlUtil.escapeJS(title) %>';
	slashdot_url='<%= url %>';
	<%= slashdotDisplayStyle %>
</aui:script>

<script src="<%= HttpUtil.getProtocol(request) %>://slashdot.org/slashdot-it.js" type="text/javascript"></script>