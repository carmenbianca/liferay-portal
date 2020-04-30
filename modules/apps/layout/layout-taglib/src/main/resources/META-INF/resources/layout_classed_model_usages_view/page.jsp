<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/layout_classed_model_usages_view/init.jsp" %>

<%
String className = (String)request.getAttribute("liferay-layout:layout-classed-model-usages-view:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-layout:layout-classed-model-usages-view:classPK"));

LayoutClassedModelUsagesDisplayContext layoutClassedModelUsagesDisplayContext = new LayoutClassedModelUsagesDisplayContext(renderRequest, renderResponse, className, classPK);
%>

<div id="<portlet:namespace />layoutClassedModelUsagesList">
	<liferay-ui:search-container
		compactEmptyResultsMessage="<%= true %>"
		searchContainer="<%= layoutClassedModelUsagesDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.layout.model.LayoutClassedModelUsage"
			modelVar="layoutClassedModelUsage"
		>
			<liferay-ui:search-container-column-text
				name="pages"
			>
				<h5>
					<%= HtmlUtil.escape(layoutClassedModelUsagesDisplayContext.getLayoutClassedModelUsageName(layoutClassedModelUsage)) %>
				</h5>

				<div class="text-secondary">
					<%= LanguageUtil.get(request, layoutClassedModelUsagesDisplayContext.getLayoutClassedModelUsageTypeLabel(layoutClassedModelUsage)) %>
				</div>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				cssClass="text-right"
			>
				<c:if test="<%= layoutClassedModelUsagesDisplayContext.isShowPreview(layoutClassedModelUsage) %>">

					<%
					Layout curLayout = LayoutLocalServiceUtil.fetchLayout(layoutClassedModelUsage.getPlid());
					%>

					<c:if test="<%= curLayout != null %>">

						<%
						Map<String, String> data = HashMapBuilder.put(
							"href", layoutClassedModelUsagesDisplayContext.getPreviewURL(layoutClassedModelUsage)
						).build();
						%>

						<clay:button
							data="<%= data %>"
							elementClasses="preview-layout-classed-model-usage table-action-link"
							icon="view"
							monospaced="<%= true %>"
							style="secondary"
						/>
					</c:if>
				</c:if>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
			paginate="<%= false %>"
			searchResultCssClass="table table-autofit table-heading-nowrap"
		/>
	</liferay-ui:search-container>
</div>

<aui:script require="metal-dom/src/all/dom as dom">
	if (
		document.querySelector('#<portlet:namespace/>layoutClassedModelUsagesList')
	) {
		var previewLayoutClassedModelUsagesList = dom.delegate(
			document.querySelector(
				'#<portlet:namespace/>layoutClassedModelUsagesList'
			),
			'click',
			'.preview-layout-classed-model-usage',
			function(event) {
				var delegateTarget = event.delegateTarget;

				Liferay.Util.openWindow({
					dialog: {
						destroyOnHide: true,
						modal: true,
					},
					dialogIframe: {
						bodyCssClass: 'dialog-with-footer article-preview',
					},
					title: '<liferay-ui:message key="preview" />',
					uri: delegateTarget.getAttribute('data-href'),
				});
			}
		);

		function removeListener() {
			previewLayoutClassedModelUsagesList.removeListener();

			Liferay.detach('destroyPortlet', removeListener);
		}

		Liferay.on('destroyPortlet', removeListener);
	}
</aui:script>