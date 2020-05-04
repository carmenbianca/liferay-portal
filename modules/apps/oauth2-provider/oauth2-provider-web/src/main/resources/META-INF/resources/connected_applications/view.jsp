<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/connected_applications/init.jsp" %>

<%
OAuth2ConnectedApplicationsManagementToolbarDisplayContext oAuth2ConnectedApplicationsManagementToolbarDisplayContext = new OAuth2ConnectedApplicationsManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, currentURLObj);

int userOAuth2AuthorizationsCount = OAuth2AuthorizationServiceUtil.getUserOAuth2AuthorizationsCount();
%>

<clay:management-toolbar
	actionDropdownItems="<%= oAuth2ConnectedApplicationsManagementToolbarDisplayContext.getActionDropdownItems() %>"
	disabled="<%= userOAuth2AuthorizationsCount == 0 %>"
	filterDropdownItems="<%= oAuth2ConnectedApplicationsManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= userOAuth2AuthorizationsCount %>"
	namespace="<%= renderResponse.getNamespace() %>"
	searchContainerId="oAuth2ConnectedApplicationsSearchContainer"
	selectable="<%= true %>"
	showSearch="<%= false %>"
	sortingOrder="<%= oAuth2ConnectedApplicationsManagementToolbarDisplayContext.getOrderByType() %>"
	sortingURL="<%= String.valueOf(oAuth2ConnectedApplicationsManagementToolbarDisplayContext.getSortingURL()) %>"
/>

<div class="container-fluid-1280">
	<aui:form action="<%= currentURLObj %>" name="fm">
		<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
		<aui:input name="oAuth2AuthorizationIds" type="hidden" />

		<liferay-ui:search-container
			emptyResultsMessage="no-connected-applications-were-found"
			id="oAuth2ConnectedApplicationsSearchContainer"
			iteratorURL="<%= currentURLObj %>"
			rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
			total="<%= userOAuth2AuthorizationsCount %>"
		>
			<liferay-ui:search-container-results
				results="<%= OAuth2AuthorizationServiceUtil.getUserOAuth2Authorizations(searchContainer.getStart(), searchContainer.getEnd(), oAuth2ConnectedApplicationsManagementToolbarDisplayContext.getOrderByComparator()) %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.oauth2.provider.model.OAuth2Authorization"
				escapedModel="<%= true %>"
				keyProperty="OAuth2AuthorizationId"
				modelVar="oAuth2Authorization"
			>

				<%
				OAuth2Application oAuth2Application = OAuth2ApplicationLocalServiceUtil.getOAuth2Application(oAuth2Authorization.getOAuth2ApplicationId());
				%>

				<liferay-ui:search-container-column-image
					src="<%= oAuth2ConnectedApplicationsPortletDisplayContext.getThumbnailURL(oAuth2Application) %>"
					toggleRowChecker="<%= true %>"
				/>

				<portlet:renderURL var="viewURL">
					<portlet:param name="mvcRenderCommandName" value="/connected_applications/view" />
					<portlet:param name="oAuth2ApplicationId" value="<%= String.valueOf(oAuth2Authorization.getOAuth2ApplicationId()) %>" />
					<portlet:param name="oAuth2AuthorizationId" value="<%= String.valueOf(oAuth2Authorization.getOAuth2AuthorizationId()) %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text
					colspan="<%= 2 %>"
				>
					<h4>
						<aui:a href="<%= viewURL.toString() %>"><%= HtmlUtil.escape(oAuth2Application.getName()) %></aui:a>
					</h4>

					<h5 class="text-default">
						<span><liferay-ui:message key="authorization" /></span>:
						<liferay-ui:message arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - oAuth2Authorization.getCreateDate().getTime(), true) %>" key="x-ago" translateArguments="<%= false %>" />
					</h5>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-jsp
					align="right"
					path="/connected_applications/authorization_actions.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				displayStyle="descriptive"
				markupView="lexicon"
			/>
		</liferay-ui:search-container>
	</aui:form>
</div>

<script>
	function <portlet:namespace />removeAccess() {
		if (
			confirm(
				'<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-remove-access-for-the-selected-entries") %>'
			)
		) {
			var form = document.<portlet:namespace />fm;

			Liferay.Util.postForm(form, {
				data: {
					oAuth2AuthorizationIds: Liferay.Util.listCheckedExcept(
						form,
						'<portlet:namespace />allRowIds'
					),
				},
				url:
					'<portlet:actionURL name="/connected_applications/revoke_oauth2_authorizations" />',
			});
		}
	}
</script>