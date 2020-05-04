<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
GroupFragmentEntryLinkDisplayContext groupFragmentEntryLinkDisplayContext = new GroupFragmentEntryLinkDisplayContext(renderRequest, renderResponse);

FragmentEntry fragmentEntry = groupFragmentEntryLinkDisplayContext.getFragmentEntry();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(groupFragmentEntryLinkDisplayContext.getRedirect());

renderResponse.setTitle(LanguageUtil.format(request, "usages-and-propagation-x", fragmentEntry.getName()));
%>

<div class="container-fluid container-fluid-max-xl container-form-lg">
	<div class="sheet">
		<div class="row">
			<div class="col-lg-12">

				<%
				GroupFragmentEntryUsageManagementToolbarDisplayContext groupFragmentEntryUsageManagementToolbarDisplayContext = new GroupFragmentEntryUsageManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, groupFragmentEntryLinkDisplayContext.getSearchContainer());
				%>

				<clay:management-toolbar
					displayContext="<%= groupFragmentEntryUsageManagementToolbarDisplayContext %>"
				/>

				<portlet:actionURL name="/fragment/propagate_group_fragment_entry_changes" var="propagateGroupFragmentEntryChangesURL">
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="fragmentEntryId" value="<%= String.valueOf(fragmentEntry.getFragmentEntryId()) %>" />
				</portlet:actionURL>

				<aui:form action="<%= propagateGroupFragmentEntryChangesURL %>" name="fm">
					<liferay-ui:search-container
						searchContainer="<%= groupFragmentEntryLinkDisplayContext.getSearchContainer() %>"
					>
						<liferay-ui:search-container-row
							className="com.liferay.portal.kernel.model.Group"
							keyProperty="groupId"
							modelVar="group"
						>
							<liferay-ui:search-container-column-text
								name="name"
								value="<%= group.getDescriptiveName(locale) %>"
							/>

							<liferay-ui:search-container-column-text
								name="usages"
								translate="<%= true %>"
								value="<%= String.valueOf(groupFragmentEntryLinkDisplayContext.getFragmentGroupUsageCount(group)) %>"
							/>
						</liferay-ui:search-container-row>

						<liferay-ui:search-iterator
							displayStyle="list"
							markupView="lexicon"
							paginate="<%= false %>"
							searchResultCssClass="show-quick-actions-on-hover table table-autofit"
						/>
					</liferay-ui:search-container>
				</aui:form>
			</div>
		</div>
	</div>
</div>

<liferay-frontend:component
	componentId="<%= groupFragmentEntryUsageManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	module="js/FragmentEntryUsageManagementToolbarDefaultEventHandler.es"
/>