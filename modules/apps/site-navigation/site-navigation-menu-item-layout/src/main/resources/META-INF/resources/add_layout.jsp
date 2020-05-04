<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean privateLayout = ParamUtil.getBoolean(request, "privateLayout");

PortletURL portletURL = currentURLObj;
%>

<clay:navigation-bar
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(!privateLayout);
						navigationItem.setHref(portletURL, "privateLayout", false);
						navigationItem.setLabel(LanguageUtil.get(request, "public-pages"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(privateLayout);
						navigationItem.setHref(portletURL, "privateLayout", true);
						navigationItem.setLabel(LanguageUtil.get(request, "private-pages"));
					});
			}
		}
	%>'
/>

<aui:input id="groupId" name="TypeSettingsProperties--groupId--" type="hidden" value="<%= scopeGroupId %>" />

<aui:input id="layoutUuid" name="TypeSettingsProperties--layoutUuid--" type="hidden" value="" />

<aui:input id="privateLayout" name="TypeSettingsProperties--privateLayout--" type="hidden" value="<%= privateLayout %>" />

<liferay-layout:select-layout
	componentId='<%= liferayPortletResponse.getNamespace() + "selectLayout" %>'
	itemSelectorSaveEvent='<%= liferayPortletResponse.getNamespace() + "selectLayout" %>'
	multiSelection="<%= true %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	pathThemeImages="<%= themeDisplay.getPathThemeImages() %>"
	privateLayout="<%= privateLayout %>"
	showHiddenLayouts="<%= true %>"
/>

<aui:script>
	var layoutUuid = document.getElementById('<portlet:namespace />layoutUuid');

	if (layoutUuid) {
		Liferay.on('<portlet:namespace />selectLayout', function(event) {
			var selectedItems = event.data;

			if (selectedItems) {
				var layoutUuids = selectedItems.reduce(function(
					previousValue,
					currentValue
				) {
					return previousValue.concat([currentValue.id]);
				},
				[]);

				layoutUuid.value = layoutUuids.join();
			}
		});
	}
</aui:script>