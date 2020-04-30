<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
DLEditFileEntryTypeDisplayContext dlEditFileEntryTypeDisplayContext = (DLEditFileEntryTypeDisplayContext)request.getAttribute(DLWebKeys.DOCUMENT_LIBRARY_EDIT_EDIT_FILE_ENTRY_TYPE_DISPLAY_CONTEXT);
%>

<c:choose>
	<c:when test="<%= dlEditFileEntryTypeDisplayContext.useDataEngineEditor() %>">
		<liferay-util:include page="/document_library/edit_file_entry_type_data_layout_builder.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/document_library/edit_file_entry_type_form_builder.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>