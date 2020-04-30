<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
DepotAdminDisplayContext depotAdminDisplayContext = new DepotAdminDisplayContext(request, liferayPortletRequest, liferayPortletResponse);

DepotAdminManagementToolbarDisplayContext depotAdminManagementToolbarDisplayContext = new DepotAdminManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, depotAdminDisplayContext);
%>

<clay:management-toolbar
	displayContext="<%= depotAdminManagementToolbarDisplayContext %>"
/>

<div class="closed container-fluid-1280 sidenav-container sidenav-right">
	<div class="sidenav-content">
		<portlet:actionURL name="deleteGroups" var="deleteGroupsURL" />

		<aui:form action="<%= depotAdminDisplayContext.getIteratorURL() %>" cssClass="container-fluid-1280" name="fm">
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />

			<liferay-ui:search-container
				id="<%= depotAdminDisplayContext.getSearchContainerId() %>"
				searchContainer="<%= depotAdminDisplayContext.searchContainer() %>"
			>
				<liferay-ui:search-container-row
					className="com.liferay.depot.model.DepotEntry"
					cssClass="entry-display-style"
					escapedModel="<%= true %>"
					keyProperty="depotEntryId"
					rowIdProperty="depotEntryId"
				>

					<%
					DepotEntry depotEntry = (DepotEntry)row.getObject();

					Group depotEntryGroup = depotEntry.getGroup();

					row.setData(depotAdminManagementToolbarDisplayContext.getRowData(depotEntry));
					%>

					<c:choose>
						<c:when test="<%= depotAdminDisplayContext.isDisplayStyleDescriptive() %>">
							<liferay-ui:search-container-column-text>
								<liferay-ui:search-container-column-icon
									icon="books"
									toggleRowChecker="<%= true %>"
								/>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text
								colspan="<%= 2 %>"
							>
								<h5>
									<aui:a cssClass="selector-button" href="<%= depotAdminDisplayContext.getViewDepotURL(depotEntry) %>">
										<%= HtmlUtil.escape(depotEntryGroup.getDescriptiveName(locale)) %>
									</aui:a>
								</h5>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text>
								<clay:dropdown-actions
									defaultEventHandler="<%= DepotAdminWebKeys.DEPOT_ENTRY_DROPDOWN_DEFAULT_EVENT_HANDLER %>"
									dropdownItems="<%= depotAdminDisplayContext.getActionDropdownItems(depotEntry) %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:when test="<%= depotAdminDisplayContext.isDisplayStyleIcon() %>">

							<%
							row.setCssClass("entry-card lfr-asset-item " + row.getCssClass());
							%>

							<liferay-ui:search-container-column-text>
								<clay:vertical-card
									verticalCard="<%= depotAdminDisplayContext.getDepotEntryVerticalCard(depotEntry) %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand table-cell-minw-200 table-title"
								name="name"
								orderable="<%= true %>"
							>
								<aui:a href="<%= depotAdminDisplayContext.getViewDepotURL(depotEntry) %>" label="<%= HtmlUtil.escape(depotEntryGroup.getDescriptiveName(locale)) %>" localizeLabel="<%= false %>" />
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text>
								<clay:dropdown-actions
									defaultEventHandler="<%= DepotAdminWebKeys.DEPOT_ENTRY_DROPDOWN_DEFAULT_EVENT_HANDLER %>"
									dropdownItems="<%= depotAdminDisplayContext.getActionDropdownItems(depotEntry) %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator
					displayStyle="<%= depotAdminDisplayContext.getDisplayStyle() %>"
					markupView="lexicon"
					searchContainer="<%= searchContainer %>"
				/>
			</liferay-ui:search-container>
		</aui:form>
	</div>
</div>

<liferay-frontend:component
	componentId="<%= DepotAdminWebKeys.DEPOT_ENTRY_DROPDOWN_DEFAULT_EVENT_HANDLER %>"
	module="js/DepotEntryDropdownDefaultEventHandler.es"
/>

<liferay-frontend:component
	componentId="<%= depotAdminManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	context="<%= depotAdminManagementToolbarDisplayContext.getComponentContext() %>"
	module="js/DepotAdminManagementToolbarDefaultEventHandler.es"
/>