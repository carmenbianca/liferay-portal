<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
long fileEntryTypeId = ParamUtil.getLong(request, "fileEntryTypeId");
String eventName = ParamUtil.getString(request, "eventName", renderResponse.getNamespace() + "selectFileEntryType");

long[] groupIds = PortalUtil.getCurrentAndAncestorSiteGroupIds(scopeGroupId);

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/document_library/select_file_entry_type.jsp");
portletURL.setParameter("eventName", eventName);
%>

<clay:navigation-bar
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(true);
						navigationItem.setLabel(LanguageUtil.get(request, "document-types"));
					});
			}
		}
	%>'
/>

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="selectFileEntryTypeFm">
	<liferay-ui:search-container
		iteratorURL="<%= portletURL %>"
	>
		<liferay-ui:search-container-results
			results="<%= DLFileEntryTypeServiceUtil.getFileEntryTypes(groupIds) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.document.library.kernel.model.DLFileEntryType"
			cssClass="select-action"
			modelVar="fileEntryType"
		>

			<%
			if (fileEntryTypeId == fileEntryType.getFileEntryTypeId()) {
				row.setCssClass("select-action active");
			}

			Map<String, Object> rowData = HashMapBuilder.<String, Object>put(
				"fileEntryTypeId", fileEntryType.getFileEntryTypeId()
			).build();

			row.setData(rowData);
			%>

			<liferay-ui:search-container-column-icon
				icon="edit-layout"
			/>

			<liferay-ui:search-container-column-text
				colspan="<%= 2 %>"
			>
				<h5><%= HtmlUtil.escape(fileEntryType.getName(locale)) %></h5>

				<h6 class="text-default">
					<span><%= fileEntryType.getDescription(locale) %></span>
				</h6>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="descriptive"
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	var form = A.one('#<portlet:namespace />selectFileEntryTypeFm');

	form.delegate(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = event.currentTarget;

			A.all('.select-action').removeClass('active');

			currentTarget.addClass('active');

			Liferay.Util.getOpener().Liferay.fire(
				'<%= HtmlUtil.escapeJS(eventName) %>',
				{
					data: currentTarget.attr('data-fileEntryTypeId'),
				}
			);
		},
		'.select-action'
	);
</aui:script>