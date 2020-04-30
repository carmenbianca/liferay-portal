<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

DDLRecordSet ddlRecordSet = (DDLRecordSet)row.getObject();

DateSearchEntry dateSearchEntry = new DateSearchEntry();

dateSearchEntry.setDate(ddlRecordSet.getModifiedDate());

String href = (String)request.getAttribute(WebKeys.SEARCH_ENTRY_HREF);
%>

<h2 class="h5">
	<aui:a cssClass="record-set-name" href="<%= href %>">
		<%= HtmlUtil.escape(ddlRecordSet.getName(locale)) %>
	</aui:a>
</h2>

<span class="text-default">
	<div class="record-set-description">
		<%= HtmlUtil.escape(ddlRecordSet.getDescription(locale)) %>
	</div>
</span>
<span class="text-default">
	<span class="record-set-id">
		<liferay-ui:message key="id" />: <%= ddlRecordSet.getRecordSetId() %>
	</span>
	<span class="record-set-modified-date">
		<liferay-ui:message key="modified-date" />: <%= dateSearchEntry.getName(request) %>
	</span>
</span>