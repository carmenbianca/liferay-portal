<%--
/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/aui/option/init.jsp" %>

<option class="<%= cssClass %>" <%= disabled ? "disabled" : StringPool.BLANK %> <%= selected ? "selected" : StringPool.BLANK %> <%= Validator.isNotNull(style) ? "style=\"" + style + "\"" : StringPool.BLANK %> value="<%= (value != null) ? String.valueOf(value) : StringPool.BLANK %>" <%= AUIUtil.buildData(data) %> <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>

<c:if test="<%= Validator.isNotNull(label) %>">
	<liferay-ui:message key="<%= String.valueOf(label) %>" localizeKey="<%= localizeLabel %>" />
</c:if>