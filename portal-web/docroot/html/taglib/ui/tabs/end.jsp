<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/tabs/init.jsp" %>

<%
String errorSection = (String)request.getAttribute(WebKeys.ERROR_SECTION);
%>

<aui:script>
	Liferay.Portal.Tabs.show('<%= namespace + param %>', <%= namesJS %>, '<%= UnicodeFormatter.toString((errorSection == null) ? value : errorSection) %>');
</aui:script>