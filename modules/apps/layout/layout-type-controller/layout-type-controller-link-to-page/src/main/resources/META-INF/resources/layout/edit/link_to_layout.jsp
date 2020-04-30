<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/layout/edit/init.jsp" %>

<aui:input name="TypeSettingsProperties--groupId--" type="hidden" value="<%= (selLayout == null) ? StringPool.BLANK : selLayout.getGroupId() %>" />
<aui:input name="TypeSettingsProperties--privateLayout--" type="hidden" value="<%= (selLayout == null) ? StringPool.BLANK : selLayout.isPrivateLayout() %>" />

<div class="form-group">
	<aui:input label="link-to-layout" name="linkToLayoutName" type="resource" value="<%= linkToPageLayoutTypeControllerDisplayContext.getLinkToLayoutName() %>" />
	<aui:input name="linkToLayoutUuid" type="hidden" value="<%= linkToPageLayoutTypeControllerDisplayContext.getLinkToLayoutUuid() %>" />

	<aui:button name="selectLayoutButton" value="select" />

	<aui:script require="frontend-js-web/liferay/ItemSelectorDialog.es as ItemSelectorDialog">
		var selectLayoutButton = document.getElementById('<portlet:namespace />selectLayoutButton');

		if (selectLayoutButton) {
			selectLayoutButton.addEventListener(
				'click',
				function(event) {
					event.preventDefault();

					const itemSelectorDialog = new ItemSelectorDialog.default({
						eventName: '<%= linkToPageLayoutTypeControllerDisplayContext.getEventName() %>',
						singleSelect: true,
						title: '<liferay-ui:message key="select-layout" />',
						url: '<%= linkToPageLayoutTypeControllerDisplayContext.getItemSelectorURL() %>'
					});

					itemSelectorDialog.on('selectedItemChange', function(event) {
						const selectedItem = event.selectedItem;

						const linkToLayoutName = document.getElementById('<portlet:namespace />linkToLayoutName');
						const linkToLayoutUuid = document.getElementById('<portlet:namespace />linkToLayoutUuid');

						if (selectedItem && linkToLayoutName && linkToLayoutUuid) {
							linkToLayoutName.value = selectedItem.name;
							linkToLayoutUuid.value = selectedItem.id;
						}
					});

					itemSelectorDialog.open();
				}
			);
		}
	</aui:script>
</div>