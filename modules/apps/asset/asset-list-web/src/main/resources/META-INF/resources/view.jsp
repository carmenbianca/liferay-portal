<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
AssetListManagementToolbarDisplayContext assetListManagementToolbarDisplayContext = new AssetListManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, assetListDisplayContext);
%>

<clay:management-toolbar
	displayContext="<%= assetListManagementToolbarDisplayContext %>"
/>

<portlet:actionURL name="/asset_list/delete_asset_list_entry" var="deleteAssetListEntryURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteAssetListEntryURL %>" cssClass="container-fluid-1280" name="fm">
	<c:choose>
		<c:when test="<%= assetListDisplayContext.getAssetListEntriesCount() > 0 %>">
			<liferay-ui:search-container
				id="assetListEntries"
				searchContainer="<%= assetListDisplayContext.getAssetListEntriesSearchContainer() %>"
			>
				<liferay-ui:search-container-row
					className="com.liferay.asset.list.model.AssetListEntry"
					keyProperty="assetListEntryId"
					modelVar="assetListEntry"
				>

					<%
					String editURL = StringPool.BLANK;

					if (AssetListEntryPermission.contains(permissionChecker, assetListEntry, ActionKeys.UPDATE)) {
						PortletURL editAssetListEntryURL = liferayPortletResponse.createRenderURL();

						editAssetListEntryURL.setParameter("mvcPath", "/edit_asset_list_entry.jsp");
						editAssetListEntryURL.setParameter("redirect", currentURL);
						editAssetListEntryURL.setParameter("assetListEntryId", String.valueOf(assetListEntry.getAssetListEntryId()));

						editURL = editAssetListEntryURL.toString();
					}

					Map<String, Object> rowData = HashMapBuilder.<String, Object>put(
						"actions", assetListManagementToolbarDisplayContext.getAvailableActions(assetListEntry)
					).build();

					row.setData(rowData);
					%>

					<liferay-ui:search-container-column-icon
						icon="list"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<aui:a href="<%= editURL %>">
								<%= HtmlUtil.escape(assetListEntry.getTitle()) %>
							</aui:a>
						</h5>

						<h6 class="text-default">
							<strong><liferay-ui:message key="<%= HtmlUtil.escape(assetListEntry.getTypeLabel()) %>" /></strong>
						</h6>

						<%
						String assetEntryTypeLabel = ResourceActionsUtil.getModelResource(locale, assetListEntry.getAssetEntryType());

						long classTypeId = GetterUtil.getLong(assetListEntry.getAssetEntrySubtype());

						if (classTypeId > 0) {
							AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(assetListEntry.getAssetEntryType());

							if ((assetRendererFactory != null) && assetRendererFactory.isSupportsClassTypes()) {
								ClassTypeReader classTypeReader = assetRendererFactory.getClassTypeReader();

								ClassType classType = classTypeReader.getClassType(classTypeId, locale);

								assetEntryTypeLabel = assetEntryTypeLabel + " - " + classType.getName();
							}
						}
						%>

						<h6 class="text-default">
							<strong><%= assetEntryTypeLabel %></strong>
						</h6>

						<%
						Date statusDate = assetListEntry.getCreateDate();
						%>

						<liferay-ui:message arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - statusDate.getTime(), true) %>" key="x-ago" translateArguments="<%= false %>" />
					</liferay-ui:search-container-column-text>

					<%
					AssetEntryListActionDropdownItems assetEntryListActionDropdownItems = new AssetEntryListActionDropdownItems(assetListEntry, liferayPortletRequest, liferayPortletResponse);
					%>

					<liferay-ui:search-container-column-text>
						<clay:dropdown-actions
							defaultEventHandler="assetEntryListDropdownDefaultEventHandler"
							dropdownItems="<%= assetEntryListActionDropdownItems.getActionDropdownItems() %>"
						/>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator
					displayStyle="descriptive"
					markupView="lexicon"
				/>
			</liferay-ui:search-container>
		</c:when>
		<c:otherwise>
			<liferay-frontend:empty-result-message
				actionDropdownItems="<%= assetListDisplayContext.isShowAddAssetListEntryAction() ? assetListDisplayContext.getAddAssetListEntryDropdownItems() : null %>"
				componentId="emptyResultMessageComponent"
				defaultEventHandler="emptyResultMessageComponentDefaultEventHandler"
				description="<%= assetListDisplayContext.getEmptyResultMessageDescription() %>"
				elementType='<%= LanguageUtil.get(request, "collections") %>'
			/>
		</c:otherwise>
	</c:choose>
</aui:form>

<c:if test="<%= assetListDisplayContext.getAssetListEntriesCount() == 0 %>">
	<liferay-frontend:component
		componentId="emptyResultMessageComponentDefaultEventHandler"
		module="js/EmptyResultMessageDefaultEventHandler.es"
	/>
</c:if>

<liferay-frontend:component
	componentId="assetEntryListDropdownDefaultEventHandler"
	module="js/AssetEntryListDropdownDefaultEventHandler.es"
/>

<liferay-frontend:component
	componentId="<%= assetListManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	module="js/ManagementToolbarDefaultEventHandler.es"
/>