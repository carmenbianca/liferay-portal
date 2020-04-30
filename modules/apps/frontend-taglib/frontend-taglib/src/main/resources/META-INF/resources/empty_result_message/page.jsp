<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/empty_result_message/init.jsp" %>

<div class="taglib-empty-result-message">
	<div class="<%= animationTypeCssClass %>"></div>

	<h1 class="taglib-empty-result-message-title">
		<c:choose>
			<c:when test="<%= Validator.isNull(title) %>">
				<liferay-ui:message arguments="<%= elementType %>" key="no-x-yet" translateArguments="<%= false %>" />
			</c:when>
			<c:otherwise>
				<%= title %>
			</c:otherwise>
		</c:choose>
	</h1>

	<c:if test="<%= Validator.isNotNull(description) %>">
		<p class="taglib-empty-result-message-description">
			<%= description %>
		</p>
	</c:if>

	<c:if test="<%= Validator.isNotNull(actionDropdownItems) %>">
		<div class="taglib-empty-result-message-actions">
			<c:choose>
				<c:when test="<%= actionDropdownItems.size() > 1 %>">
					<clay:dropdown-menu
						componentId="<%= componentId %>"
						defaultEventHandler="<%= defaultEventHandler %>"
						dropdownItems="<%= actionDropdownItems %>"
						label='<%= LanguageUtil.get(request, "new") %>'
						style="primary"
						triggerCssClasses="btn-sm"
					/>
				</c:when>
				<c:otherwise>

					<%
					DropdownItem actionDropdownItem = actionDropdownItems.get(0);
					%>

					<c:choose>
						<c:when test='<%= Validator.isNotNull(actionDropdownItem.get("href")) %>'>
							<clay:link
								buttonStyle="primary"
								componentId="<%= componentId %>"
								data='<%= (HashMap)actionDropdownItem.get("data") %>'
								defaultEventHandler="<%= defaultEventHandler %>"
								href='<%= String.valueOf(actionDropdownItem.get("href")) %>'
								label='<%= String.valueOf(actionDropdownItem.get("label")) %>'
							/>
						</c:when>
						<c:otherwise>
							<clay:button
								componentId="<%= componentId %>"
								data='<%= (HashMap)actionDropdownItem.get("data") %>'
								defaultEventHandler="<%= defaultEventHandler %>"
								label='<%= String.valueOf(actionDropdownItem.get("label")) %>'
								style="primary"
							/>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</div>
	</c:if>
</div>