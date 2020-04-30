<%--
/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/aui/nav_bar/init.jsp" %>

<c:if test="<%= Validator.isContent(bodyContentString) %>">
	<div class="navbar navbar-default <%= cssClass %>" id="<%= id %>" <%= AUIUtil.buildData(data) %> <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
		<div class="container-fluid">
			<c:if test="<%= Validator.isNotNull(responsiveButtons) %>">
				<div class="navbar-header">
					<%= responsiveButtons %>
				</div>
			</c:if>

			<%= bodyContentString %>
		</div>
	</div>
</c:if>