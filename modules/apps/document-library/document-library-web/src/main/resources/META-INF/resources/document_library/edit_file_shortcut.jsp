<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

DLEditFileShortcutDisplayContext dlEditFileShortcutDisplayContext = (DLEditFileShortcutDisplayContext)request.getAttribute(DLWebKeys.DOCUMENT_LIBRARY_EDIT_FILE_SHORTCUT_DISPLAY_CONTEXT);

renderResponse.setTitle(dlEditFileShortcutDisplayContext.getTitle());
%>

<clay:container>
	<aui:form action="<%= dlEditFileShortcutDisplayContext.getEditFileShortcutURL() %>" method="post" name="fm">
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="fileShortcutId" type="hidden" value="<%= dlEditFileShortcutDisplayContext.getFileShortcutId() %>" />
		<aui:input name="repositoryId" type="hidden" value="<%= dlEditFileShortcutDisplayContext.getRepositoryId() %>" />
		<aui:input name="folderId" type="hidden" value="<%= dlEditFileShortcutDisplayContext.getFolderId() %>" />
		<aui:input name="toFileEntryId" type="hidden" value="<%= dlEditFileShortcutDisplayContext.getToFileEntryId() %>" />

		<liferay-ui:error exception="<%= FileShortcutPermissionException.class %>" message="you-do-not-have-permission-to-create-a-shortcut-to-the-selected-document" />
		<liferay-ui:error exception="<%= NoSuchFileEntryException.class %>" message="the-document-could-not-be-found" />

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>
				<div class="alert alert-info">
					<liferay-ui:message key="you-can-create-a-shortcut-to-any-document-that-you-have-read-access-for" />
				</div>

				<div class="form-group">
					<aui:input label="document" name="toFileEntryTitle" type="resource" value="<%= dlEditFileShortcutDisplayContext.getToFileEntryTitle() %>" />

					<aui:button name="selectToFileEntryButton" value="select" />
				</div>
			</aui:fieldset>

			<c:if test="<%= dlEditFileShortcutDisplayContext.isPermissionConfigurable() %>">
				<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="permissions">
					<liferay-ui:input-permissions
						modelName="<%= DLFileShortcutConstants.getClassName() %>"
					/>
				</aui:fieldset>
			</c:if>
		</aui:fieldset-group>

		<aui:button-row>
			<aui:button type="submit" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:form>
</clay:container>

<aui:script require="frontend-js-web/liferay/ItemSelectorDialog.es as ItemSelectorDialog">
	var selectToFileEntryButton = document.getElementById(
		'<portlet:namespace />selectToFileEntryButton'
	);

	if (selectToFileEntryButton) {
		var itemSelectorDialog = new ItemSelectorDialog.default({
			eventName: '<portlet:namespace />toFileEntrySelectedItem',
			singleSelect: true,
			title: '<liferay-ui:message arguments="file" key="select-x" />',
			url: '<%= dlEditFileShortcutDisplayContext.getItemSelectorURL() %>',
		});

		itemSelectorDialog.on('selectedItemChange', function (event) {
			var selectedItem = event.selectedItem;

			if (selectedItem) {
				var itemValue = JSON.parse(selectedItem.value);

				var toFileEntryId = document.getElementById(
					'<portlet:namespace />toFileEntryId'
				);

				if (toFileEntryId) {
					toFileEntryId.value = itemValue.fileEntryId;
				}

				var toFileEntryTitle = document.getElementById(
					'<portlet:namespace />toFileEntryTitle'
				);

				if (toFileEntryTitle) {
					toFileEntryTitle.value = itemValue.title;
				}
			}
		});

		selectToFileEntryButton.addEventListener('click', function (event) {
			event.preventDefault();
			itemSelectorDialog.open();
		});
	}
</aui:script>