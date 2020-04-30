<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SelectLayoutPageTemplateEntryDisplayContext selectLayoutPageTemplateEntryDisplayContext = new SelectLayoutPageTemplateEntryDisplayContext(request);

List<LayoutPageTemplateEntry> masterLayoutPageTemplateEntries = selectLayoutPageTemplateEntryDisplayContext.getMasterLayoutPageTemplateEntries();
%>

<div class="lfr-search-container-wrapper" id="<portlet:namespace/>layoutTypes">
	<c:if test="<%= ListUtil.isNotEmpty(masterLayoutPageTemplateEntries) %>">
		<ul class="card-page card-page-equal-height">

			<%
			for (LayoutPageTemplateEntry masterLayoutPageTemplateEntry : masterLayoutPageTemplateEntries) {
			%>

				<li class="card-page-item col-md-4 col-sm-6">
					<clay:vertical-card
						verticalCard="<%= new SelectBasicTemplatesVerticalCard(masterLayoutPageTemplateEntry, renderRequest, renderResponse) %>"
					/>
				</li>

			<%
			}
			%>

		</ul>
	</c:if>

	<c:if test="<%= selectLayoutPageTemplateEntryDisplayContext.getTypesCount() > 0 %>">
		<h6 class="sheet-subtitle">
			<liferay-ui:message key="other" />
		</h6>

		<ul class="card-page card-page-equal-height">

			<%
			for (String type : selectLayoutPageTemplateEntryDisplayContext.getTypes()) {
			%>

				<li class="card-page-item col-md-4 col-sm-6">
					<clay:horizontal-card
						horizontalCard="<%= new SelectBasicTemplatesHorizontalCard(type, renderRequest, renderResponse) %>"
					/>
				</li>

			<%
			}
			%>

		</ul>
	</c:if>
</div>