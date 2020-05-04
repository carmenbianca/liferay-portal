<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SelectLayoutPageTemplateEntryDisplayContext selectLayoutPageTemplateEntryDisplayContext = new SelectLayoutPageTemplateEntryDisplayContext(request);
%>

<div id="<portlet:namespace />layoutPageTemplateEntries">
	<liferay-ui:search-container
		iteratorURL="<%= currentURLObj %>"
		total="<%= selectLayoutPageTemplateEntryDisplayContext.getGlobalLayoutPageTemplateEntriesCount() %>"
	>
		<liferay-ui:search-container-results
			results="<%= selectLayoutPageTemplateEntryDisplayContext.getGlobalLayoutPageTemplateEntries() %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.layout.page.template.model.LayoutPageTemplateEntry"
			modelVar="layoutPageTemplateEntry"
		>

			<%
			row.setCssClass("entry-card lfr-asset-item " + row.getCssClass());
			%>

			<liferay-ui:search-container-column-text>
				<clay:vertical-card
					verticalCard="<%= new SelectGlobalTemplatesVerticalCard(layoutPageTemplateEntry, renderRequest, renderResponse) %>"
				/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="icon"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>