<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage="there-are-no-servers"
		iteratorURL="<%= portletURL %>"
		total="<%= PowwowServerLocalServiceUtil.getPowwowServersCount() %>"
	>
		<liferay-ui:search-container-results
			results="<%= PowwowServerLocalServiceUtil.getPowwowServers(searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator()) %>"
		/>

		<aui:button-row>
			<portlet:renderURL var="addURL">
				<portlet:param name="mvcPath" value="/admin/edit_server.jsp" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			</portlet:renderURL>

			<aui:button onClick="<%= addURL.toString() %>" value="add-server" />
		</aui:button-row>

		<liferay-ui:search-container-row
			className="com.liferay.powwow.model.PowwowServer"
			escapedModel="<%= true %>"
			keyProperty="powwowServerId"
			modelVar="powwowServer"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcPath" value="/admin/edit_server.jsp" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
				<portlet:param name="powwowServerId" value="<%= String.valueOf(powwowServer.getPowwowServerId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand table-cell-minw-200 table-title"
				href="<%= rowURL %>"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-expand table-cell-minw-200"
				href="<%= rowURL %>"
				name="provider"
				value="<%= PowwowServiceProviderUtil.getPowwowServiceProviderName(powwowServer.getProviderType()) %>"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-minw-150"
				href="<%= rowURL %>"
				name="branding-name"
				value="<%= LanguageUtil.get(request, PowwowServiceProviderUtil.getBrandingLabel(powwowServer.getProviderType())) %>"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-ws-nowrap"
				href="<%= rowURL %>"
				name="active"
				property="active"
			/>

			<liferay-ui:search-container-column-jsp
				cssClass="entry-action"
				path="/admin/server_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="list"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>