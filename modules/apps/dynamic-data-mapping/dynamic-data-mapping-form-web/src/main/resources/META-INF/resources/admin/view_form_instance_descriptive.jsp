<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

DDMFormInstance ddmFormInstance = (DDMFormInstance)row.getObject();

DateSearchEntry dateSearchEntry = new DateSearchEntry();

dateSearchEntry.setDate(ddmFormInstance.getModifiedDate());

String href = (String)request.getAttribute(WebKeys.SEARCH_ENTRY_HREF);
%>

<div class="clamp-container">
	<h2 class="h5 text-truncate">
		<aui:a cssClass="form-instance-name" href="<%= href %>">
			<%= HtmlUtil.escape(ddmFormInstance.getName(locale)) %>
		</aui:a>
	</h2>

	<span class="text-default">
		<div class="form-instance-description text-truncate">
			<%= HtmlUtil.escape(ddmFormInstance.getDescription(locale)) %>
		</div>
	</span>
	<span class="text-default">
		<span class="form-instance-id">
			<liferay-ui:message key="id" />: <%= ddmFormInstance.getFormInstanceId() %>
		</span>
		<span class="form-instance-modified-date">
			<liferay-ui:message key="modified-date" />: <%= dateSearchEntry.getName(request) %>
		</span>
	</span>
</div>