<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Folder folder = (Folder)row.getObject();

folder = folder.toEscapedModel();

Date modifiedDate = folder.getLastPostDate();

String modifiedDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - modifiedDate.getTime(), true);

PortletURL rowURL = liferayPortletResponse.createRenderURL();

rowURL.setParameter("mvcRenderCommandName", "/document_library/view_folder");
rowURL.setParameter("redirect", currentURL);
rowURL.setParameter("folderId", String.valueOf(folder.getFolderId()));
%>

<h2 class="h5">
	<aui:a href="<%= rowURL.toString() %>">
		<%= folder.getName() %>
	</aui:a>
</h2>

<span>
	<c:choose>
		<c:when test="<%= Validator.isNull(folder.getUserName()) %>">
			<liferay-ui:message arguments="<%= new String[] {modifiedDateDescription} %>" key="modified-x-ago" />
		</c:when>
		<c:otherwise>
			<liferay-ui:message arguments="<%= new String[] {folder.getUserName(), modifiedDateDescription} %>" key="x-modified-x-ago" />
		</c:otherwise>
	</c:choose>
</span>
<span>
	<%= DLUtil.getAbsolutePath(liferayPortletRequest, folder.getParentFolderId()).replace(StringPool.RAQUO_CHAR, StringPool.GREATER_THAN) %>
</span>