<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/aui/nav/init.jsp" %>

<c:if test="<%= Validator.isContent(bodyContentString) %>">
	<c:if test="<%= collapsible %>">
		<div class="collapse navbar-collapse" id="<%= id %>NavbarCollapse">
	</c:if>

	<ul aria-label="<%= Validator.isNull(ariaLabel) ? HtmlUtil.escapeAttribute(portletDisplay.getTitle()) : ariaLabel %>" class="lfr-nav nav <%= cssClass %>" id="<%= id %>" role="<%= Validator.isNull(ariaRole) ? "menubar" : ariaRole %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
		<%= bodyContentString %>
	</ul>

	<c:if test="<%= collapsible %>">
		</div>
	</c:if>
</c:if>