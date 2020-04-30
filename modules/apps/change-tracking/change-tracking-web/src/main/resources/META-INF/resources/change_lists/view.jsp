<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/change_lists/init.jsp" %>

<%
SearchContainer<CTCollection> searchContainer = changeListsDisplayContext.getSearchContainer();

ChangeListsManagementToolbarDisplayContext changeListsManagementToolbarDisplayContext = new ChangeListsManagementToolbarDisplayContext(changeListsDisplayContext, request, liferayPortletRequest, liferayPortletResponse, searchContainer);
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= changeListsDisplayContext.getViewNavigationItems() %>"
/>

<clay:management-toolbar
	displayContext="<%= changeListsManagementToolbarDisplayContext %>"
/>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		cssClass="change-lists-table"
		searchContainer="<%= searchContainer %>"
		var="changeListsSearchContainer"
	>
		<liferay-ui:search-container-row
			className="com.liferay.change.tracking.model.CTCollection"
			escapedModel="<%= true %>"
			keyProperty="ctCollectionId"
			modelVar="ctCollection"
		>
			<c:choose>
				<c:when test='<%= Objects.equals(changeListsDisplayContext.getDisplayStyle(), "descriptive") %>'>
					<liferay-ui:search-container-column-text>
						<span class="lfr-portal-tooltip" title="<%= HtmlUtil.escape(ctCollection.getUserName()) %>">
							<liferay-ui:user-portrait
								userId="<%= ctCollection.getUserId() %>"
							/>
						</span>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="autofit-col-expand"
						href="<%= changeListsDisplayContext.getReviewChangesURL(ctCollection.getCtCollectionId()) %>"
					>
						<div class="change-list-name <%= (changeListsDisplayContext.getCtCollectionId() == ctCollection.getCtCollectionId()) ? "font-italic" : StringPool.BLANK %>">
							<%= ctCollection.getName() %>
						</div>

						<div class="change-list-description <%= (changeListsDisplayContext.getCtCollectionId() == ctCollection.getCtCollectionId()) ? "font-italic" : StringPool.BLANK %>">
							<%= ctCollection.getDescription() %>
						</div>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:otherwise>
					<liferay-ui:search-container-column-text
						cssClass="table-cell-expand"
						href="<%= changeListsDisplayContext.getReviewChangesURL(ctCollection.getCtCollectionId()) %>"
						name="publication"
					>
						<div class="change-list-name <%= (changeListsDisplayContext.getCtCollectionId() == ctCollection.getCtCollectionId()) ? "font-italic" : StringPool.BLANK %>">
							<%= ctCollection.getName() %>
						</div>

						<div class="change-list-description <%= (changeListsDisplayContext.getCtCollectionId() == ctCollection.getCtCollectionId()) ? "font-italic" : StringPool.BLANK %>">
							<%= ctCollection.getDescription() %>
						</div>
					</liferay-ui:search-container-column-text>

					<%
					Date modifiedDate = ctCollection.getModifiedDate();
					%>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-expand-smaller"
						name="last-modified"
					>
						<liferay-ui:message arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - modifiedDate.getTime(), true) %>" key="x-ago" translateArguments="<%= false %>" />
					</liferay-ui:search-container-column-text>

					<%
					Date createDate = ctCollection.getCreateDate();
					%>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-expand-smaller"
						name="created"
					>
						<liferay-ui:message arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - createDate.getTime(), true) %>" key="x-ago" translateArguments="<%= false %>" />
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-expand-smallest text-center"
						name="owner"
					>
						<span class="lfr-portal-tooltip" title="<%= HtmlUtil.escape(ctCollection.getUserName()) %>">
							<liferay-ui:user-portrait
								userId="<%= ctCollection.getUserId() %>"
							/>
						</span>
					</liferay-ui:search-container-column-text>
				</c:otherwise>
			</c:choose>

			<liferay-ui:search-container-column-jsp
				path="/change_lists/ct_collection_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= changeListsDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
			searchContainer="<%= searchContainer %>"
		/>
	</liferay-ui:search-container>
</div>