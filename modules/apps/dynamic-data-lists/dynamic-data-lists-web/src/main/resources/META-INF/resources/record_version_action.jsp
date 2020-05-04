<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long formDDMTemplateId = ParamUtil.getLong(request, "formDDMTemplateId");

DDLRecord record = (DDLRecord)request.getAttribute(DDLWebKeys.DYNAMIC_DATA_LISTS_RECORD);

DDLRecordVersion recordVersion = (DDLRecordVersion)request.getAttribute(DDLWebKeys.DYNAMIC_DATA_LISTS_RECORD_VERSION);
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<liferay-portlet:renderURL portletName="<%= DDLPortletKeys.DYNAMIC_DATA_LISTS %>" var="viewRecordVersionURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="mvcPath" value="/view_record.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="recordId" value="<%= String.valueOf(recordVersion.getRecordId()) %>" />
		<portlet:param name="version" value="<%= recordVersion.getVersion() %>" />
		<portlet:param name="formDDMTemplateId" value="<%= String.valueOf(formDDMTemplateId) %>" />
	</liferay-portlet:renderURL>

	<liferay-ui:icon
		message="view[action]"
		url="<%= viewRecordVersionURL %>"
	/>

	<c:if test="<%= recordVersion.isApproved() && !Objects.equals(record.getVersion(), recordVersion.getVersion()) %>">
		<portlet:actionURL name="revertRecord" var="revertURL">
			<portlet:param name="mvcPath" value="/edit_record.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="recordId" value="<%= String.valueOf(recordVersion.getRecordId()) %>" />
			<portlet:param name="version" value="<%= String.valueOf(recordVersion.getVersion()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			message="revert"
			url="<%= revertURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>