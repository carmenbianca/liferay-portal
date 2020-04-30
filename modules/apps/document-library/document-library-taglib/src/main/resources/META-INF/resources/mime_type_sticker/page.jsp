<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String cssClass = (String)request.getAttribute("liferay-document-library:mime-type-sticker:cssClass");
DLViewFileVersionDisplayContext dlViewFileVersionDisplayContext = (DLViewFileVersionDisplayContext)request.getAttribute("liferay-document-library:mime-type-sticker:dlViewFileVersionDisplayContext");
%>

<div class="sticker sticker-document <%= cssClass %> <%= dlViewFileVersionDisplayContext.getCssClassFileMimeType() %>">
	<clay:icon
		symbol="<%= dlViewFileVersionDisplayContext.getIconFileMimeType() %>"
	/>
</div>