<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
List<ConfigurationCategorySectionDisplay> configurationCategorySectionDisplays = (List<ConfigurationCategorySectionDisplay>)request.getAttribute(ConfigurationAdminWebKeys.CONFIGURATION_CATEGORY_SECTION_DISPLAYS);
ConfigurationEntryRetriever configurationEntryRetriever = (ConfigurationEntryRetriever)request.getAttribute(ConfigurationAdminWebKeys.CONFIGURATION_ENTRY_RETRIEVER);
ConfigurationScopeDisplayContext configurationScopeDisplayContext = ConfigurationScopeDisplayContextFactory.create(renderRequest);
%>

<portlet:renderURL var="redirectURL" />

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcRenderCommandName" value="/search" />
	<portlet:param name="redirect" value="<%= redirectURL %>" />
</portlet:renderURL>

<clay:management-toolbar
	searchActionURL="<%= searchURL %>"
	selectable="<%= false %>"
	showSearch="<%= true %>"
/>

<div class="container-fluid container-fluid-max-xl container-view">
	<c:if test="<%= configurationCategorySectionDisplays.isEmpty() %>">
		<liferay-ui:empty-result-message
			message="no-configurations-were-found"
		/>
	</c:if>

	<ul class="list-group <%= configurationCategorySectionDisplays.isEmpty() ? "hide" : StringPool.BLANK %>">

		<%
		for (ConfigurationCategorySectionDisplay configurationCategorySectionDisplay : configurationCategorySectionDisplays) {
		%>

			<li class="list-group-header">
				<h3 class="list-group-header-title text-uppercase">
					<%= HtmlUtil.escape(configurationCategorySectionDisplay.getConfigurationCategorySectionLabel(locale)) %>
				</h3>
			</li>
			<li class="list-group-card">
				<ul class="list-group">

					<%
					for (ConfigurationCategoryDisplay configurationCategoryDisplay : configurationCategorySectionDisplay.getConfigurationCategoryDisplays()) {
						ConfigurationCategoryMenuDisplay configurationCategoryMenuDisplay = configurationEntryRetriever.getConfigurationCategoryMenuDisplay(configurationCategoryDisplay.getCategoryKey(), themeDisplay.getLanguageId(), configurationScopeDisplayContext.getScope(), configurationScopeDisplayContext.getScopePK());

						if (configurationCategoryMenuDisplay.isEmpty()) {
							continue;
						}

						String viewCategoryHREF = ConfigurationCategoryUtil.getHREF(configurationCategoryMenuDisplay, liferayPortletResponse, renderRequest, renderResponse);
					%>

						<li class="list-group-card-item">
							<a href="<%= viewCategoryHREF %>">
								<clay:icon
									elementClasses="user-icon-sm"
									symbol="<%= configurationCategoryDisplay.getCategoryIcon() %>"
								/>

								<span class="list-group-card-item-text">
									<%= HtmlUtil.escape(configurationCategoryDisplay.getCategoryLabel(locale)) %>
								</span>
							</a>
						</li>

					<%
					}
					%>

				</ul>
			</li>

		<%
		}
		%>

	</ul>
</div>