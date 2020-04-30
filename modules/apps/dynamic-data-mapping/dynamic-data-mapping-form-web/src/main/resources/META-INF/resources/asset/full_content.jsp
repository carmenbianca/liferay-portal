<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/asset/init.jsp" %>

<%
DDMFormViewFormInstanceRecordDisplayContext ddmFormViewFormInstanceRecordDisplayContext = (DDMFormViewFormInstanceRecordDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>

<div class="container-fluid-1280">
	<%= ddmFormViewFormInstanceRecordDisplayContext.getDDMFormHTML(renderRequest) %>
</div>