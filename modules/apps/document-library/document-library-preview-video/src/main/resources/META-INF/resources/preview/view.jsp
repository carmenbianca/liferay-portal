<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/preview/init.jsp" %>

<%
List<String> previewFileURLs = (List<String>)request.getAttribute(DLPreviewVideoWebKeys.PREVIEW_FILE_URLS);
String videoPosterURL = (String)request.getAttribute(DLPreviewVideoWebKeys.VIDEO_POSTER_URL);
%>

<liferay-util:html-top
	outputKey="document_library_preview_video_css"
>
	<link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/preview/css/main.css") %>" rel="stylesheet" type="text/css" />
</liferay-util:html-top>

<div class="preview-file">
	<div class="preview-file-container preview-file-max-height">
		<video
			class="preview-file-video"
			controls
			controlsList="nodownload"

			<c:if test="<%= Validator.isNotNull(videoPosterURL) %>">
				poster="<%= videoPosterURL %>"
			</c:if>
		>

			<%
			for (String previewFileURL : previewFileURLs) {
				String type = null;

				if (Validator.isNotNull(previewFileURL)) {
					if (previewFileURL.endsWith("mp4")) {
						type = "video/mp4";
					}
					else if (previewFileURL.endsWith("ogv")) {
						type = "video/ogv";
					}
				}

				if (type != null) {
			%>

					<source src="<%= previewFileURL %>" type="<%= type %>" />

			<%
				}
			}
			%>

		</video>
	</div>
</div>