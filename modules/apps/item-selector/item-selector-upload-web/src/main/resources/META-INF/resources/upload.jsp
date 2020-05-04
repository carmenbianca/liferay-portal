<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ItemSelectorUploadViewDisplayContext itemSelectorUploadViewDisplayContext = (ItemSelectorUploadViewDisplayContext)request.getAttribute(ItemSelectorUploadView.ITEM_SELECTOR_UPLOAD_VIEW_DISPLAY_CONTEXT);

ItemSelectorReturnTypeResolver itemSelectorReturnTypeResolver = itemSelectorUploadViewDisplayContext.getItemSelectorReturnTypeResolver();

Class<?> itemSelectorReturnTypeClass = itemSelectorReturnTypeResolver.getItemSelectorReturnTypeClass();

String uploadURL = itemSelectorUploadViewDisplayContext.getURL();

String namespace = itemSelectorUploadViewDisplayContext.getNamespace();

if (Validator.isNotNull(namespace)) {
	uploadURL = HttpUtil.addParameter(uploadURL, namespace + "returnType", itemSelectorReturnTypeClass.getName());
}

Map<String, Object> context = HashMapBuilder.<String, Object>put(
	"closeCaption", itemSelectorUploadViewDisplayContext.getTitle(locale)
).put(
	"eventName", itemSelectorUploadViewDisplayContext.getItemSelectedEventName()
).put(
	"maxFileSize", itemSelectorUploadViewDisplayContext.getMaxFileSize()
).put(
	"rootNode", "#itemSelectorUploadContainer"
).put(
	"uploadItemReturnType", HtmlUtil.escapeAttribute(itemSelectorReturnTypeClass.getName())
).put(
	"uploadItemURL", uploadURL
).put(
	"validExtensions", ArrayUtil.isEmpty(itemSelectorUploadViewDisplayContext.getExtensions()) ? "*" : StringUtil.merge(itemSelectorUploadViewDisplayContext.getExtensions())
).build();
%>

<div class="container-fluid-1280 lfr-item-viewer" id="itemSelectorUploadContainer">
	<div class="drop-enabled drop-zone item-selector upload-view">
		<div id="uploadDescription">
			<c:if test="<%= !BrowserSnifferUtil.isMobile(request) %>">
				<p>
					<strong><liferay-ui:message arguments="<%= itemSelectorUploadViewDisplayContext.getRepositoryName() %>" key="drag-and-drop-to-upload-to-x-or" /></strong>
				</p>
			</c:if>

			<p>
				<input accept="<%= ArrayUtil.isEmpty(itemSelectorUploadViewDisplayContext.getExtensions()) ? "*" : StringUtil.merge(itemSelectorUploadViewDisplayContext.getExtensions()) %>" class="input-file" id="<portlet:namespace />inputFile" type="file" />

				<label class="btn btn-secondary" for="<portlet:namespace />inputFile"><liferay-ui:message key="select-file" /></label>
			</p>
		</div>
	</div>

	<liferay-ui:drop-here-info
		message="drop-files-here"
	/>

	<div class="item-selector-preview-container"></div>
</div>

<liferay-frontend:component
	context="<%= context %>"
	module="js/index.es"
/>