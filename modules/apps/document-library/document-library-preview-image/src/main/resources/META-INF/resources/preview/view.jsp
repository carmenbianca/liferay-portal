<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/preview/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "portlet_document_library_view_file_entry_preview") + StringPool.UNDERLINE;

FileVersion fileVersion = (FileVersion)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_VERSION);

String previewQueryString = "&imagePreview=1";

int status = ParamUtil.getInteger(request, "status", WorkflowConstants.STATUS_ANY);

if (status != WorkflowConstants.STATUS_ANY) {
	previewQueryString += "&status=" + status;
}

String previewURL = DLURLHelperUtil.getPreviewURL(fileVersion.getFileEntry(), fileVersion, themeDisplay, previewQueryString);
%>

<liferay-util:html-top
	outputKey="document_library_preview_image_css"
>
	<link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/preview/css/main.css") %>" rel="stylesheet" type="text/css" />
</liferay-util:html-top>

<c:choose>
	<c:when test="<%= Objects.equals(fileVersion.getMimeType(), ContentTypes.IMAGE_SVG_XML) %>">
		<div class="preview-file">
			<div class="preview-file-container preview-file-max-height">
				<img class="preview-file-image-vectorial" src="<%= previewURL %>" />
			</div>
		</div>
	</c:when>
	<c:otherwise>

		<%
		Map<String, Object> data = HashMapBuilder.<String, Object>put(
			"imageURL", previewURL
		).build();
		%>

		<div id="<%= renderResponse.getNamespace() + randomNamespace + "previewImage" %>">
			<react:component
				data="<%= data %>"
				module="preview/js/ImagePreviewer.es"
			/>
		</div>
	</c:otherwise>
</c:choose>