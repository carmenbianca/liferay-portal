<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/edit_form/init.jsp" %>

<%
String fullName = namespace.concat(HtmlUtil.escapeAttribute(name));
%>

<form action="<%= HtmlUtil.escapeAttribute(action) %>" class="container container-no-gutters-sm-down container-view form <%= cssClass %> <%= inlineLabels ? "field-labels-inline" : StringPool.BLANK %>" data-fm-namespace="<%= namespace %>" id="<%= fullName %>" method="<%= method %>" name="<%= fullName %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
	<c:if test="<%= !themeDisplay.isStatePopUp() %>">
		<div class="sheet <%= fluid ? StringPool.BLANK : "sheet-lg" %>">
	</c:if>

		<div class="panel-group panel-group-flush">
			<c:if test="<%= Validator.isNotNull(onSubmit) %>">
				<fieldset class="input-container" disabled="disabled">
			</c:if>

			<aui:input name="formDate" type="hidden" value="<%= System.currentTimeMillis() %>" />