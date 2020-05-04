<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long recordSetId = ParamUtil.getLong(request, renderResponse.getNamespace() + "recordSetId");
%>

<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="exportRecordSet" var="exportRecordSetURL">
	<portlet:param name="recordSetId" value="<%= String.valueOf(recordSetId) %>" />
</liferay-portlet:resourceURL>

<%
StringBundler sb = new StringBundler(5);

sb.append("javascript:");
sb.append(renderResponse.getNamespace());
sb.append("exportRecordSet('");
sb.append(exportRecordSetURL);
sb.append("');");
%>

<liferay-ui:icon
	message="export"
	url="<%= sb.toString() %>"
/>