<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
long selectAllCount = GetterUtil.getLong(request.getAttribute(DLWebKeys.DOCUMENT_LIBRARY_SELECT_ALL_COUNT));
%>

<div class="sidebar-header">
	<h1 class="sidebar-title">
		<liferay-ui:message key="selection" />
	</h1>
</div>

<div class="sidebar-body">
	<liferay-ui:tabs
		cssClass="navbar-no-collapse"
		names="details"
		refresh="<%= false %>"
	>
		<liferay-ui:section>
			<strong>
				<liferay-ui:message arguments="<%= selectAllCount %>" key="x-items-are-selected" />
			</strong>
		</liferay-ui:section>
	</liferay-ui:tabs>
</div>