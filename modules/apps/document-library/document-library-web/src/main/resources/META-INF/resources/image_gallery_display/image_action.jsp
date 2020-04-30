<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/image_gallery_display/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

FileEntry fileEntry = null;
FileShortcut fileShortcut = null;

if (row != null) {
	Object result = row.getObject();

	if (result instanceof AssetEntry) {
		AssetEntry assetEntry = (AssetEntry)result;

		if (assetEntry.getClassName().equals(DLFileEntryConstants.getClassName())) {
			fileEntry = DLAppLocalServiceUtil.getFileEntry(assetEntry.getClassPK());
		}
		else {
			fileShortcut = DLAppLocalServiceUtil.getFileShortcut(assetEntry.getClassPK());
		}
	}
	else if (result instanceof FileEntry) {
		fileEntry = (FileEntry)result;
	}
	else if (result instanceof FileShortcut) {
		fileShortcut = (FileShortcut)result;
	}
}

IGViewFileVersionDisplayContext igViewFileVersionDisplayContext = null;

if (fileShortcut == null) {
	igViewFileVersionDisplayContext = igDisplayContextProvider.getIGViewFileVersionActionsDisplayContext(request, response, fileEntry.getFileVersion());
}
else {
	igViewFileVersionDisplayContext = igDisplayContextProvider.getIGViewFileVersionActionsDisplayContext(request, response, fileShortcut);
}
%>

<liferay-ui:menu
	menu="<%= igViewFileVersionDisplayContext.getMenu() %>"
/>