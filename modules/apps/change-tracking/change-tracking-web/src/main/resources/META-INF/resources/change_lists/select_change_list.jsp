<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/change_lists/init.jsp" %>

<%
SearchContainer<CTCollection> searchContainer = changeListsDisplayContext.getSearchContainer();

searchContainer.setId("selectChangeList");

SelectChangeListManagementToolbarDisplayContext selectChangeListManagementToolbarDisplayContext = new SelectChangeListManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, searchContainer);
%>

<clay:management-toolbar
	displayContext="<%= selectChangeListManagementToolbarDisplayContext %>"
/>

<c:if test="<%= !searchContainer.hasResults() %>">
	<div class="contact-information-empty-results-message-wrapper">
		<liferay-ui:empty-result-message
			message="<%= searchContainer.getEmptyResultsMessage() %>"
		/>
	</div>
</c:if>

<div class="container container-fluid-1280" id="<portlet:namespace />selectChangeListContainer">
	<div class="table-responsive">
		<table class="change-lists-table select-change-list-table table table-autofit">
			<tbody>

				<%
				for (CTCollection ctCollection : searchContainer.getResults()) {
					Map<String, Object> data = HashMapBuilder.<String, Object>put(
						"ctcollectionid", ctCollection.getCtCollectionId()
					).build();
				%>

					<tr>
						<td>
							<span class="lfr-portal-tooltip" title="<%= HtmlUtil.escape(ctCollection.getUserName()) %>">
								<liferay-ui:user-portrait
									userId="<%= ctCollection.getUserId() %>"
								/>
							</span>
						</td>
						<td class="table-cell-expand">
							<c:choose>
								<c:when test="<%= ctCollection.getCtCollectionId() == changeListsDisplayContext.getCtCollectionId() %>">
									<div class="change-list-name font-italic">
										<%= HtmlUtil.escape(ctCollection.getName()) %>
									</div>

									<div class="change-list-description font-italic">
										<%= HtmlUtil.escape(ctCollection.getDescription()) %>
									</div>
								</c:when>
								<c:otherwise>
									<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
										<div class="change-list-name">
											<%= HtmlUtil.escape(ctCollection.getName()) %>
										</div>

										<div class="change-list-description">
											<%= HtmlUtil.escape(ctCollection.getDescription()) %>
										</div>
									</aui:a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

				<%
				}
				%>

			</tbody>
		</table>
	</div>

	<liferay-ui:search-paginator
		markupView="lexicon"
		searchContainer="<%= searchContainer %>"
	/>
</div>

<aui:script>
	Liferay.Util.selectEntityHandler(
		'#<portlet:namespace />selectChangeListContainer',
		'<portlet:namespace />selectChangeList'
	);
</aui:script>