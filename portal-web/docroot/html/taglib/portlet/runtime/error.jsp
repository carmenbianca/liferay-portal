<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
String errorMessage = (String)request.getAttribute("liferay-portlet:runtime:errorMessage");
%>

<div class="alert alert-warning lfr-configurator-visibility lfr-meta-actions">
	<%= errorMessage %>
</div>