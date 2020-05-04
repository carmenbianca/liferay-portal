<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/rss/init.jsp" %>

<%
String message = (String)request.getAttribute("liferay-rss:rss:message");
String url = (String)request.getAttribute("liferay-rss:rss:url");
%>

<liferay-ui:icon
	label="<%= true %>"
	message="<%= HtmlUtil.escape(message) %>"
	method="get"
	target="_blank"
	url="<%= url %>"
/>

<liferay-util:html-top>
	<link href="<%= HtmlUtil.escapeAttribute(url) %>" rel="alternate" title="RSS" type="application/rss+xml" />
</liferay-util:html-top>