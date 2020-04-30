<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/aui/form/init.jsp" %>

<%
String fullName = namespace.concat(HtmlUtil.escapeAttribute(name));
%>

<form action="<%= HtmlUtil.escapeAttribute(action) %>" class="form <%= cssClass %> <%= inlineLabels ? "field-labels-inline" : StringPool.BLANK %>" data-fm-namespace="<%= namespace %>" id="<%= fullName %>" method="<%= method %>" name="<%= fullName %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
	<c:if test="<%= Validator.isNotNull(onSubmit) %>">
		<fieldset class="input-container" disabled="disabled">
	</c:if>

	<aui:input name="formDate" type="hidden" value="<%= System.currentTimeMillis() %>" />