<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
Folder parentFolder = (Folder)request.getAttribute("info_panel_location.jsp-parentFolder");

long parentFolderId = (parentFolder == null) ? DLFolderConstants.DEFAULT_PARENT_FOLDER_ID : parentFolder.getFolderId();
%>

<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, parentFolderId, ActionKeys.VIEW) %>">
	<dt class="sidebar-dt">
		<liferay-ui:message key="location" />
	</dt>
	<dd class="sidebar-dd">

		<%
		PortletURL viewFolderURL = liferayPortletResponse.createRenderURL();

		if (parentFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			viewFolderURL.setParameter("mvcRenderCommandName", "/document_library/view");
		}
		else {
			viewFolderURL.setParameter("mvcRenderCommandName", "/document_library/view_folder");
			viewFolderURL.setParameter("folderId", String.valueOf(parentFolderId));
		}

		viewFolderURL.setParameter("redirect", currentURL);
		%>

		<clay:link
			href="<%= viewFolderURL.toString() %>"
			icon="folder"
			label='<%= (parentFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) ? LanguageUtil.get(request, "home") : parentFolder.getName() %>'
			style="secondary"
		/>
	</dd>
</c:if>