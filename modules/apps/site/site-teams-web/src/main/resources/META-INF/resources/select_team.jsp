<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SelectTeamDisplayContext selectTeamDisplayContext = new SelectTeamDisplayContext(request, renderRequest, renderResponse);
%>

<clay:management-toolbar
	displayContext="<%= new SelectTeamManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, selectTeamDisplayContext) %>"
/>

<aui:form cssClass="container-fluid-1280" name="selectTeamFm">
	<liferay-ui:search-container
		searchContainer="<%= selectTeamDisplayContext.getTeamSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.TeamModel"
			keyProperty="teamId"
			modelVar="curTeam"
			rowVar="row"
		>

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"entityid", curTeam.getTeamId()
			).put(
				"entityname", curTeam.getName()
			).put(
				"teamdescription", curTeam.getDescription()
			).build();

			Group group = themeDisplay.getScopeGroup();

			long[] defaultTeamIds = StringUtil.split(group.getTypeSettingsProperties().getProperty("defaultTeamIds"), 0L);

			long[] teamIds = ParamUtil.getLongValues(request, "teamIds", defaultTeamIds);

			boolean disabled = ArrayUtil.contains(teamIds, curTeam.getTeamId());
			%>

			<c:choose>
				<c:when test='<%= Objects.equals(selectTeamDisplayContext.getDisplayStyle(), "descriptive") %>'>
					<liferay-ui:search-container-column-icon
						icon="users"
						toggleRowChecker="<%= true %>"
					/>

					<liferay-ui:search-container-column-text
						colspan="<%= 2 %>"
					>
						<h5>
							<c:choose>
								<c:when test="<%= !disabled %>">
									<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
										<%= HtmlUtil.escape(curTeam.getName()) %>
									</aui:a>
								</c:when>
								<c:otherwise>
									<%= HtmlUtil.escape(curTeam.getName()) %>
								</c:otherwise>
							</c:choose>
						</h5>

						<h6 class="text-default">
							<span><%= HtmlUtil.escape(curTeam.getDescription()) %></span>
						</h6>
					</liferay-ui:search-container-column-text>
				</c:when>
				<c:when test='<%= Objects.equals(selectTeamDisplayContext.getDisplayStyle(), "list") %>'>
					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="name"
					>
						<c:choose>
							<c:when test="<%= !disabled %>">
								<aui:a cssClass="selector-button" data="<%= data %>" href="javascript:;">
									<%= HtmlUtil.escape(curTeam.getName()) %>
								</aui:a>
							</c:when>
							<c:otherwise>
								<%= HtmlUtil.escape(curTeam.getName()) %>
							</c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="description"
						value="<%= HtmlUtil.escape(curTeam.getDescription()) %>"
					/>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= selectTeamDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.selectEntityHandler(
		'#<portlet:namespace />selectTeamFm',
		'<%= HtmlUtil.escapeJS(selectTeamDisplayContext.getEventName()) %>'
	);
</aui:script>