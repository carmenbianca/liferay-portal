<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<clay:navigation-bar
	navigationItems="<%= siteBrowserDisplayContext.getNavigationItems() %>"
/>

<clay:management-toolbar
	displayContext="<%= new SiteBrowserManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, siteBrowserDisplayContext) %>"
/>

<aui:form action="<%= siteBrowserDisplayContext.getPortletURL() %>" cssClass="container-fluid-1280" method="post" name="selectGroupFm">
	<liferay-ui:search-container
		searchContainer="<%= siteBrowserDisplayContext.getGroupSearch() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.Group"
			escapedModel="<%= true %>"
			keyProperty="groupId"
			modelVar="group"
			rowIdProperty="friendlyURL"
			rowVar="row"
		>

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"entityid", group.getGroupId()
			).put(
				"entityname", group.getDescriptiveName(locale)
			).put(
				"grouptarget", siteBrowserDisplayContext.getTarget()
			).put(
				"grouptype", LanguageUtil.get(request, group.getTypeLabel())
			).put(
				"url", group.getDisplayURL(themeDisplay)
			).build();
			%>

			<c:choose>
				<c:when test='<%= Objects.equals(siteBrowserDisplayContext.getDisplayStyle(), "descriptive") %>'>
					<liferay-ui:search-container-column-icon
						icon="sites"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<c:choose>
								<c:when test="<%= siteBrowserDisplayContext.isShowLink(group) %>">
									<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
										<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
									</aui:a>
								</c:when>
								<c:otherwise>
									<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
								</c:otherwise>
							</c:choose>
						</h5>

						<h6 class="text-default">
							<span><%= LanguageUtil.get(request, group.getScopeLabel(themeDisplay)) %></span>
						</h6>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(siteBrowserDisplayContext.getDisplayStyle(), "icon") %>'>

					<%
					row.setCssClass("entry-card lfr-asset-item " + row.getCssClass());
					%>

					<liferay-ui:search-container-column-text>
						<clay:vertical-card
							verticalCard="<%= new SiteVerticalCard(group, renderRequest, siteBrowserDisplayContext) %>"
						/>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(siteBrowserDisplayContext.getDisplayStyle(), "list") %>'>
					<liferay-ui:search-container-column-text
						name="name"
						truncate="<%= true %>"
					>
						<c:choose>
							<c:when test="<%= siteBrowserDisplayContext.isShowLink(group) %>">
								<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
									<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
								</aui:a>
							</c:when>
							<c:otherwise>
								<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
							</c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="type"
						value="<%= LanguageUtil.get(request, group.getScopeLabel(themeDisplay)) %>"
					/>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= siteBrowserDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	var Util = Liferay.Util;

	var openingLiferay = Util.getOpener().Liferay;

	openingLiferay.fire('<portlet:namespace />enableRemovedSites', {
		selectors: document.querySelectorAll('.selector-button:disabled'),
	});

	Util.selectEntityHandler(
		'#<portlet:namespace />selectGroupFm',
		'<%= HtmlUtil.escapeJS(siteBrowserDisplayContext.getEventName()) %>',
		<%= siteBrowserDisplayContext.getSelUser() != null %>
	);
</aui:script>