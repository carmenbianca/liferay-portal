<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/group_selector/init.jsp" %>

<%
GroupSelectorDisplayContext groupSelectorDisplayContext = new GroupSelectorDisplayContext(liferayPortletRequest);

Set<String> groupTypes = groupSelectorDisplayContext.getGroupTypes();
%>

<c:if test="<%= groupTypes.size() > 1 %>">
	<div class="container-fluid-1280">
		<div class="btn-group btn-group-sm my-3" role="group">

			<%
			for (String curGroupType : groupTypes) {
			%>

				<a class="btn btn-secondary <%= groupSelectorDisplayContext.isGroupTypeActive(curGroupType) ? "active" : StringPool.BLANK %>" href="<%= groupSelectorDisplayContext.getGroupItemSelectorURL(curGroupType) %>"><%= groupSelectorDisplayContext.getGroupItemSelectorLabel(curGroupType) %></a>

			<%
			}
			%>

		</div>
	</div>
</c:if>

<div class="container-fluid-1280 lfr-item-viewer">
	<liferay-ui:search-container
		searchContainer="<%= groupSelectorDisplayContext.getSearchContainer() %>"
		var="listSearchContainer"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.Group"
			cssClass="entry-card lfr-asset-item"
			modelVar="curGroup"
		>
			<liferay-ui:search-container-column-text
				colspan="<%= 3 %>"
			>
				<liferay-frontend:horizontal-card
					text="<%= curGroup.getDescriptiveName(locale) %>"
					url="<%= groupSelectorDisplayContext.getViewGroupURL(curGroup) %>"
				>
					<liferay-frontend:horizontal-card-col>
						<c:choose>
							<c:when test="<%= Validator.isNotNull(curGroup.getLogoURL(themeDisplay, false)) %>">
								<span class="sticker sticker-rounded">
									<span class="sticker-overlay">
										<img alt="" class="sticker-img" src="<%= curGroup.getLogoURL(themeDisplay, false) %>" />
									</span>
								</span>
							</c:when>
							<c:otherwise>
								<liferay-frontend:horizontal-card-icon
									icon="<%= groupSelectorDisplayContext.getGroupItemSelectorIcon() %>"
								/>
							</c:otherwise>
						</c:choose>
					</liferay-frontend:horizontal-card-col>
				</liferay-frontend:horizontal-card>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="icon"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>