<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
EditFragmentEntryDisplayContext editFragmentEntryDisplayContext = new EditFragmentEntryDisplayContext(request, renderResponse);
%>

<div>
	<react:component
		data="<%= editFragmentEntryDisplayContext.getFragmentEditorData() %>"
		module="js/fragment-editor/FragmentEditor"
	/>
</div>