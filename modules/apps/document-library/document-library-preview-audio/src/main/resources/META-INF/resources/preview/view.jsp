<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/preview/init.jsp" %>

<%
List<String> previewFileURLs = (List<String>)request.getAttribute(DLPreviewAudioWebKeys.PREVIEW_FILE_URLS);
%>

<liferay-util:html-top
	outputKey="document_library_preview_audio_css"
>
	<link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/preview/css/main.css") %>" rel="stylesheet" type="text/css" />
</liferay-util:html-top>

<div class="preview-file">
	<div class="preview-file-container">
		<audio
			class="preview-file-audio"
			controls
			controlsList="nodownload"
			style="max-width: <%= PropsValues.DL_FILE_ENTRY_PREVIEW_VIDEO_WIDTH %>px;"
		>

			<%
			for (String previewFileURL : previewFileURLs) {
				String type = null;

				if (Validator.isNotNull(previewFileURL)) {
					if (previewFileURL.endsWith("mp3")) {
						type = "audio/mp3";
					}
					else if (previewFileURL.endsWith("ogg")) {
						type = "audio/ogg";
					}
				}

				if (type != null) {
			%>

					<source src="<%= previewFileURL %>" type="<%= type %>" />

			<%
				}
			}
			%>

		</audio>
	</div>
</div>