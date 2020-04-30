<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SelectUsersDisplayContext selectUsersDisplayContext = (SelectUsersDisplayContext)request.getAttribute(SegmentsWebKeys.SELECT_USERS_DISPLAY_CONTEXT);
%>

<clay:management-toolbar
	displayContext="<%= new SelectUsersManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, selectUsersDisplayContext) %>"
/>

<aui:form cssClass="container-fluid-1280" name="fm">
	<liferay-ui:search-container
		id="selectSegmentsEntryUsers"
		searchContainer="<%= selectUsersDisplayContext.getUserSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.User"
			escapedModel="<%= true %>"
			keyProperty="userId"
			modelVar="user2"
			rowIdProperty="screenName"
		>

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"id", user2.getUserId()
			).put(
				"name", user2.getFullName()
			).build();

			row.setData(data);
			%>

			<c:choose>
				<c:when test='<%= Objects.equals(selectUsersDisplayContext.getDisplayStyle(), "icon") %>'>

					<%
					row.setCssClass("entry-card lfr-asset-item selectable");
					%>

					<liferay-ui:search-container-column-text>
						<clay:user-card
							userCard="<%= new SelectUserUserCard(user2, renderRequest, searchContainer.getRowChecker()) %>"
						/>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(selectUsersDisplayContext.getDisplayStyle(), "descriptive") %>'>
					<liferay-ui:search-container-column-text>
						<liferay-ui:user-portrait
							userId="<%= user2.getUserId() %>"
						/>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5><%= user2.getFullName() %></h5>

						<h6 class="text-default">
							<span><%= user2.getScreenName() %></span>
						</h6>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:otherwise>
					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="name"
						property="fullName"
					/>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="screen-name"
						property="screenName"
					/>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= selectUsersDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<liferay-util:include page="/field/select_js.jsp" servletContext="<%= application %>">
	<liferay-util:param name="displayStyle" value="<%= selectUsersDisplayContext.getDisplayStyle() %>" />
	<liferay-util:param name="searchContainerId" value="selectSegmentsEntryUsers" />
	<liferay-util:param name="selectEventName" value="<%= selectUsersDisplayContext.getEventName() %>" />
</liferay-util:include>