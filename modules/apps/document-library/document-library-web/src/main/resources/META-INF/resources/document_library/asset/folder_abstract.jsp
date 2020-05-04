<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
int abstractLength = GetterUtil.getInteger(request.getAttribute(WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH), AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH);

Folder folder = (Folder)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FOLDER);
%>

<div class="asset-summary">
	<div class="aspect-ratio aspect-ratio-8-to-3 bg-light mb-4">
		<div class="aspect-ratio-item-center-middle aspect-ratio-item-fluid card-type-asset-icon">
			<div class="text-secondary">
				<svg aria-hidden="true" class="lexicon-icon lexicon-icon-folder reference-mark user-icon-xl">
					<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg#folder" />
				</svg>
			</div>
		</div>
	</div>

	<%= HtmlUtil.replaceNewLine(HtmlUtil.escape(StringUtil.shorten(folder.getDescription(), abstractLength))) %>
</div>