<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long segmentsEntryId = ParamUtil.getLong(request, "segmentsEntryId");
%>

<div class="container-fluid container-fluid-max-sm">
	<liferay-ui:search-container
		emptyResultsMessage="no-users-have-been-assigned-to-this-segment"
		iteratorURL="<%= currentURLObj %>"
		total="<%= SegmentsEntryDisplayContext.getSegmentsEntryUsersCount(segmentsEntryId) %>"
		var="segmentsEntryUsersSearchContainer"
	>
		<liferay-ui:search-container-results
			results="<%= SegmentsEntryDisplayContext.getSegmentsEntryUsers(segmentsEntryId, segmentsEntryUsersSearchContainer.getStart(), segmentsEntryUsersSearchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.User"
			escapedModel="<%= true %>"
			keyProperty="userId"
			modelVar="user2"
		>
			<liferay-ui:search-container-column-text>
				<liferay-ui:user-portrait
					userId="<%= user2.getUserId() %>"
				/>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				colspan="<%= 2 %>"
				cssClass="justify-content-center"
				value="<%= user2.getFullName() %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="descriptive"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>