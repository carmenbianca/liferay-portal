<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/aui/field_wrapper/init.jsp" %>

<%
String fieldCss = AUIUtil.buildCss("field-wrapper", false, first, last, cssClass);
%>

<div class="<%= controlGroupCss %> <%= fieldCss %>" <%= AUIUtil.buildData(data) %>>
	<<%= showForLabel ? "label" : "span" %> <%= AUIUtil.buildLabel("wrapper", inlineField, showForLabel, name, disabled) %>>
		<liferay-ui:message key="<%= label %>" localizeKey="<%= localizeLabel %>" />

		<c:if test="<%= required %>">
			<aui:icon cssClass="reference-mark text-warning" image="asterisk" markupView="lexicon" />

			<span class="hide-accessible"><liferay-ui:message key="required" /></span>
		</c:if>

		<c:if test="<%= Validator.isNotNull(helpMessage) %>">
			<liferay-ui:icon-help message="<%= helpMessage %>" />
		</c:if>
	</<%= showForLabel ? "label" : "span" %>>