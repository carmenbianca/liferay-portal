<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/image_editor/configuration/icon/init.jsp" %>

<%
FileVersion fileVersion = (FileVersion)request.getAttribute(ImageEditorIntegrationDLWebKeys.IMAGE_EDITOR_INTEGRATION_DL_FILE_VERSION);

ImageEditorDLDisplayContextHelper imageEditorDLDisplayContextHelper = new ImageEditorDLDisplayContextHelper(fileVersion, request, DLURLHelperUtil.getDLURLHelper());
%>

<liferay-ui:menu-item
	menuItem="<%= imageEditorDLDisplayContextHelper.getJavacriptEditWithImageEditorMenuItem(resourceBundle) %>"
/>