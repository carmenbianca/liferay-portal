<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
RedirectNotFoundEntriesDisplayContext redirectNotFoundEntriesDisplayContext = new RedirectNotFoundEntriesDisplayContext(request, liferayPortletRequest, liferayPortletResponse);

SearchContainer<RedirectNotFoundEntry> redirectNotFoundEntriesSearchContainer = redirectNotFoundEntriesDisplayContext.searchContainer();

RedirectNotFountEntriesManagementToolbarDisplayContext redirectNotFoundEntriesManagementToolbarDisplayContext = new RedirectNotFountEntriesManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, redirectNotFoundEntriesSearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= redirectNotFoundEntriesManagementToolbarDisplayContext %>"
/>

<aui:form action="<%= redirectNotFoundEntriesSearchContainer.getIteratorURL() %>" cssClass="container-fluid-1280" name="fm">

	<%
	List<RedirectNotFoundEntry> results = redirectNotFoundEntriesSearchContainer.getResults();
	%>

	<c:choose>
		<c:when test="<%= results.size() > 0 %>">
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />

			<liferay-ui:search-container
				id="<%= redirectNotFoundEntriesDisplayContext.getSearchContainerId() %>"
				searchContainer="<%= redirectNotFoundEntriesSearchContainer %>"
			>
				<liferay-ui:search-container-row
					className="com.liferay.redirect.model.RedirectNotFoundEntry"
					keyProperty="redirectNotFoundEntryId"
					modelVar="redirectNotFoundEntry"
				>
					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="not-found-urls"
					>
						<%= HtmlUtil.escape(RedirectUtil.getGroupBaseURL(themeDisplay) + StringPool.SLASH + redirectNotFoundEntry.getUrl()) %>
					</liferay-ui:search-container-column-text>

					<c:if test='<%= StringUtil.equals("all", ParamUtil.getString(request, "filterType")) %>'>
						<liferay-ui:search-container-column-text
							cssClass="table-cell-minw-200 table-cell-smallest table-column-text-center"
							name="ignored-urls"
						>
							<c:if test="<%= redirectNotFoundEntry.isIgnored() %>">
								<clay:icon
									symbol="hidden"
								/>
							</c:if>
						</liferay-ui:search-container-column-text>
					</c:if>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-expand-smallest"
						name="requests"
					>
						<%= redirectNotFoundEntry.getHits() %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text>
						<clay:dropdown-actions
							dropdownItems="<%= redirectNotFoundEntriesDisplayContext.getActionDropdownItems(redirectNotFoundEntry) %>"
						/>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator
					markupView="lexicon"
					searchContainer="<%= redirectNotFoundEntriesSearchContainer %>"
				/>
			</liferay-ui:search-container>
		</c:when>
		<c:otherwise>
			<liferay-frontend:empty-result-message
				animationType="<%= EmptyResultMessageKeys.AnimationType.SEARCH %>"
				description="<%= LanguageUtil.get(request, redirectNotFoundEntriesSearchContainer.getEmptyResultsMessage()) %>"
				title='<%= LanguageUtil.get(request, "all-is-in-order") %>'
			/>
		</c:otherwise>
	</c:choose>
</aui:form>