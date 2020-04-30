<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute("view.jsp-assetRenderer");
String fullContentRedirect = (String)request.getAttribute("view.jsp-fullContentRedirect");

AssetEntryActionDropdownItemsProvider assetEntryActionDropdownItemsProvider = new AssetEntryActionDropdownItemsProvider(assetRenderer, assetPublisherDisplayContext.getAssetEntryActions(assetEntry.getClassName()), fullContentRedirect, liferayPortletRequest, liferayPortletResponse);

List<DropdownItem> dropdownItems = assetEntryActionDropdownItemsProvider.getActionDropdownItems();
%>

<c:if test="<%= ListUtil.isNotEmpty(dropdownItems) %>">
	<c:choose>
		<c:when test="<%= dropdownItems.size() > 1 %>">
			<liferay-ui:icon-menu
				cssClass="visible-interaction"
				direction="left-side"
				icon="<%= StringPool.BLANK %>"
				markupView="lexicon"
				message="<%= StringPool.BLANK %>"
				showWhenSingleIcon="<%= true %>"
				triggerCssClass="text-primary"
			>

				<%
				for (DropdownItem dropdownItem : dropdownItems) {
					Map data = (HashMap)dropdownItem.get("data");

					boolean useDialog = GetterUtil.getBoolean(data.get("useDialog"));
				%>

					<liferay-ui:icon
						data="<%= data %>"
						message='<%= String.valueOf(dropdownItem.get("label")) %>'
						method="get"
						url='<%= String.valueOf(dropdownItem.get("href")) %>'
						useDialog="<%= useDialog %>"
					/>

				<%
				}
				%>

			</liferay-ui:icon-menu>
		</c:when>
		<c:otherwise>

			<%
			DropdownItem dropdownItem = dropdownItems.get(0);

			Map data = (HashMap)dropdownItem.get("data");

			boolean useDialog = GetterUtil.getBoolean(data.get("useDialog"));
			%>

			<liferay-ui:icon
				cssClass="visible-interaction"
				data='<%= (HashMap)dropdownItem.get("data") %>'
				icon='<%= String.valueOf(dropdownItem.get("icon")) %>'
				linkCssClass="text-primary"
				markupView="lexicon"
				method="get"
				url='<%= String.valueOf(dropdownItem.get("href")) %>'
				useDialog="<%= useDialog %>"
			/>
		</c:otherwise>
	</c:choose>
</c:if>