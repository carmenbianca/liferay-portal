<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<liferay-util:dynamic-include key="com.liferay.document.library.web#/document_library/view_file_entry_simple_view.jsp#pre" />

<%
FileEntry fileEntry = (FileEntry)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_ENTRY);

FileVersion fileVersion = (FileVersion)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_VERSION);

if (fileVersion == null) {
	fileVersion = fileEntry.getFileVersion();
}

DLViewFileVersionDisplayContext dlViewFileVersionDisplayContext = dlDisplayContextProvider.getDLViewFileVersionDisplayContext(request, response, fileVersion);
%>

<liferay-util:html-top
	outputKey="document_library_preview_css"
>
	<link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/document_library/css/document_library_preview.css") %>" rel="stylesheet" type="text/css" />
</liferay-util:html-top>

<div class="view">
	<div class="body-row">
		<aui:model-context bean="<%= fileVersion %>" model="<%= DLFileVersion.class %>" />

		<%
		dlViewFileVersionDisplayContext.renderPreview(request, response);
		%>

	</div>
</div>

<liferay-util:dynamic-include key="com.liferay.document.library.web#/document_library/view_file_entry_simple_view.jsp#post" />