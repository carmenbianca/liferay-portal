<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/aui/field_wrapper/init.jsp" %>

	<<%= showForLabel ? "label" : "span" %> <%= AUIUtil.buildLabel("wrapper", inlineField, showForLabel, name, disabled) %>>
		<liferay-ui:message key="<%= label %>" />

		<c:if test="<%= required %>">
			<span class="icon-asterisk text-warning">
				<span class="hide-accessible"><liferay-ui:message key="required" /></span>
			</span>
		</c:if>

		<c:if test="<%= Validator.isNotNull(helpMessage) %>">
			<liferay-ui:icon-help message="<%= helpMessage %>" />
		</c:if>
	</<%= showForLabel ? "label" : "span" %>>
</div>