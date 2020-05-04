<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:icon-menu
	direction="down"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
	triggerCssClass="btn btn-unstyled text-secondary"
>
	<c:if test="<%= fragmentDisplayContext.hasUpdatePermission() %>">
		<portlet:renderURL var="editFragmentCollectionURL">
			<portlet:param name="mvcRenderCommandName" value="/fragment/edit_fragment_collection" />
			<portlet:param name="redirect" value="<%= fragmentDisplayContext.getRedirect() %>" />
			<portlet:param name="fragmentCollectionId" value="<%= String.valueOf(fragmentDisplayContext.getFragmentCollectionId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editFragmentCollectionURL %>"
		/>
	</c:if>

	<portlet:resourceURL id="/fragment/export_fragment_collections" var="exportFragmentCollectionsURL">
		<portlet:param name="fragmentCollectionId" value="<%= String.valueOf(fragmentDisplayContext.getFragmentCollectionId()) %>" />
	</portlet:resourceURL>

	<liferay-ui:icon
		message="export"
		url="<%= exportFragmentCollectionsURL %>"
	/>

	<c:if test="<%= fragmentDisplayContext.hasUpdatePermission() %>">
		<liferay-ui:icon
			message="import"
			onClick='<%= "openImportCollectionView();" %>'
			url="javascript:;"
		/>
	</c:if>

	<c:if test="<%= fragmentDisplayContext.hasDeletePermission() %>">
		<portlet:renderURL var="redirectURL">
			<portlet:param name="mvcRenderCommandName" value="/fragment/view" />
		</portlet:renderURL>

		<portlet:actionURL name="/fragment/delete_fragment_collection" var="deleteFragmentCollectionURL">
			<portlet:param name="redirect" value="<%= redirectURL %>" />
			<portlet:param name="fragmentCollectionId" value="<%= String.valueOf(fragmentDisplayContext.getFragmentCollectionId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteFragmentCollectionURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>

<c:if test="<%= fragmentDisplayContext.hasUpdatePermission() %>">
	<aui:script>
		var openImportCollectionView = function() {
			Liferay.Util.openModal({
				buttons: [
					{
						displayType: 'secondary',
						label: '<liferay-ui:message key="cancel" />',
						type: 'cancel',
					},
					{
						label: '<liferay-ui:message key="import" />',
						type: 'submit',
					},
				],
				id: '<portlet:namespace />openImportCollectionView',
				onClose: function() {
					window.location.reload();
				},
				title: '<liferay-ui:message key="import" />',
				url:
					'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcRenderCommandName" value="/fragment/view_import" /><portlet:param name="fragmentCollectionId" value="<%= String.valueOf(fragmentDisplayContext.getFragmentCollectionId()) %>" /></portlet:renderURL>',
			});
		};
	</aui:script>
</c:if>