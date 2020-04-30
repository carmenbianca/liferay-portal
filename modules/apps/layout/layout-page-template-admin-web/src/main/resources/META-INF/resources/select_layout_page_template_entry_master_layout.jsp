<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

List<LayoutPageTemplateEntry> masterLayoutPageTemplateEntries = new ArrayList<>();

LayoutPageTemplateEntry layoutPageTemplateEntry = LayoutPageTemplateEntryLocalServiceUtil.createLayoutPageTemplateEntry(0);

layoutPageTemplateEntry.setName(LanguageUtil.get(request, "blank"));
layoutPageTemplateEntry.setStatus(WorkflowConstants.STATUS_APPROVED);

masterLayoutPageTemplateEntries.add(layoutPageTemplateEntry);

masterLayoutPageTemplateEntries.addAll(LayoutPageTemplateEntryServiceUtil.getLayoutPageTemplateEntries(scopeGroupId, LayoutPageTemplateEntryTypeConstants.TYPE_MASTER_LAYOUT, WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null));

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(LanguageUtil.get(request, "select-master-page"));
%>

<div class="container-fluid-1280 mt-4">
	<div class="lfr-search-container-wrapper">
		<ul class="card-page card-page-equal-height">

			<%
			for (LayoutPageTemplateEntry masterLayoutPageTemplateEntry : masterLayoutPageTemplateEntries) {
			%>

				<li class="card-page-item col-md-4 col-sm-6">
					<clay:vertical-card
						verticalCard="<%= new SelectLayoutPageTemplateEntryMasterLayoutVerticalCard(masterLayoutPageTemplateEntry, renderRequest, renderResponse) %>"
					/>
				</li>

			<%
			}
			%>

		</ul>
	</div>
</div>

<aui:script require="metal-dom/src/all/dom as dom,frontend-js-web/liferay/modal/commands/OpenSimpleInputModal.es as openSimpleInputModal" sandbox="<%= true %>">
	var addPageTemplateClickHandler = dom.delegate(
		document.body,
		'click',
		'.add-master-page-action-option',
		function(event) {
			var data = event.delegateTarget.dataset;

			event.preventDefault();

			openSimpleInputModal.default({
				dialogTitle: '<liferay-ui:message key="add-page-template" />',
				formSubmitURL: data.addLayoutPageTemplateEntryUrl,
				mainFieldLabel: '<liferay-ui:message key="name" />',
				mainFieldName: 'name',
				mainFieldPlaceholder: '<liferay-ui:message key="name" />',
				namespace: '<portlet:namespace />',
				spritemap:
					'<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg',
			});
		}
	);

	function handleDestroyPortlet() {
		addPageTemplateClickHandler.removeListener();

		Liferay.detach('destroyPortlet', handleDestroyPortlet);
	}

	Liferay.on('destroyPortlet', handleDestroyPortlet);
</aui:script>