<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
DDLRecordSet recordSet = (DDLRecordSet)request.getAttribute(DDLWebKeys.DYNAMIC_DATA_LISTS_RECORD_SET);

long displayDDMTemplateId = ParamUtil.getLong(request, "displayDDMTemplateId");

DDLDisplayTemplateTransformer ddlDisplayTemplateTransformer = new DDLDisplayTemplateTransformer(displayDDMTemplateId, recordSet, themeDisplay, renderRequest);
%>

<div class="main-content-body">
	<%= ddlDisplayTemplateTransformer.transform() %>
</div>