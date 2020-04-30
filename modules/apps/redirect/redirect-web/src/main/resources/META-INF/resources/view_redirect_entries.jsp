<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
RedirectDisplayContext redirectDisplayContext = new RedirectDisplayContext(request, liferayPortletRequest, liferayPortletResponse);

SearchContainer<RedirectEntry> redirectSearchContainer = redirectDisplayContext.searchContainer();

RedirectManagementToolbarDisplayContext redirectManagementToolbarDisplayContext = new RedirectManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, redirectSearchContainer);
%>

<clay:management-toolbar
	displayContext="<%= redirectManagementToolbarDisplayContext %>"
/>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">
	<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="/redirect/info_panel" var="sidebarPanelURL" />

	<liferay-frontend:sidebar-panel
		resourceURL="<%= sidebarPanelURL %>"
		searchContainerId="<%= redirectDisplayContext.getSearchContainerId() %>"
	>
		<liferay-util:include page="/info_panel.jsp" servletContext="<%= application %>" />
	</liferay-frontend:sidebar-panel>

	<div class="sidenav-content">
		<aui:form action="<%= redirectSearchContainer.getIteratorURL() %>" cssClass="container-fluid-1280" name="fm">
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />

			<liferay-ui:search-container
				id="<%= redirectDisplayContext.getSearchContainerId() %>"
				searchContainer="<%= redirectSearchContainer %>"
			>
				<liferay-ui:search-container-row
					className="com.liferay.redirect.model.RedirectEntry"
					keyProperty="redirectEntryId"
					modelVar="redirectEntry"
				>

					<%
					row.setData(HashMapBuilder.<String, Object>put("actions", redirectManagementToolbarDisplayContext.getAvailableActions(redirectEntry)).build());
					%>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="source-url"
					>

						<%
						String url = RedirectUtil.getGroupBaseURL(themeDisplay) + StringPool.SLASH + redirectEntry.getSourceURL();
						%>

						<aui:a href="<%= HtmlUtil.escapeAttribute(url) %>" target="_blank">
							<%= HtmlUtil.escape(url) %>
						</aui:a>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="destination-url"
					>
						<aui:a href="<%= HtmlUtil.escapeAttribute(redirectEntry.getDestinationURL()) %>" target="_blank">
							<%= HtmlUtil.escape(redirectEntry.getDestinationURL()) %>
						</aui:a>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-expand-smallest"
						name="type"
					>
						<liferay-ui:message key='<%= redirectEntry.isPermanent() ? "permanent" : "temporary" %>' />
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-expand-smallest"
						name="expiration"
					>
						<c:choose>
							<c:when test="<%= Validator.isNull(redirectEntry.getExpirationDate()) %>">
								<%= StringPool.DASH %>
							</c:when>
							<c:when test="<%= DateUtil.compareTo(redirectEntry.getExpirationDate(), DateUtil.newDate()) <= 0 %>">
								<strong><liferay-ui:message key="expired" /></strong>
							</c:when>
							<c:otherwise>
								<%= redirectDisplayContext.formatExpirationDate(redirectEntry.getExpirationDate()) %>
							</c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text>
						<clay:dropdown-actions
							dropdownItems="<%= redirectDisplayContext.getActionDropdownItems(redirectEntry) %>"
						/>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator
					markupView="lexicon"
					searchContainer="<%= redirectSearchContainer %>"
				/>
			</liferay-ui:search-container>
		</aui:form>
	</div>
</div>

<liferay-frontend:component
	componentId="<%= redirectManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	context="<%= redirectManagementToolbarDisplayContext.getComponentContext() %>"
	module="js/RedirectManagementToolbarDefaultEventHandler.es"
/>