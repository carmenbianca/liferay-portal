<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/layout/init.jsp" %>

<%@ include file="/layout/view/embedded_js.jspf" %>

<div id="iframe">

	<%
	UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();
	%>

	<iframe frameborder="0" id="embeddedIframe" src="<%= HtmlUtil.escapeHREF(typeSettingsProperties.getProperty("embeddedLayoutURL")) %>" width="100%"></iframe>
</div>

<liferay-ui:layout-common />