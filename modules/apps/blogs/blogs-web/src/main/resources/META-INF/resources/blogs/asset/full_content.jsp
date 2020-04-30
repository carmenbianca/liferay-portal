<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-util:dynamic-include key="com.liferay.blogs.web#/blogs/asset/full_content.jsp#pre" />

<%
BlogsEntry entry = (BlogsEntry)request.getAttribute(WebKeys.BLOGS_ENTRY);

String entryTitle = BlogsEntryUtil.getDisplayTitle(resourceBundle, entry);
%>

<div class="widget-mode-simple" data-analytics-asset-id="<%= String.valueOf(entry.getEntryId()) %>" data-analytics-asset-title="<%= HtmlUtil.escapeAttribute(entryTitle) %>" data-analytics-asset-type="blog">
	<div class="widget-mode-simple-entry">
		<div class="widget-content" id="<portlet:namespace /><%= entry.getEntryId() %>">

			<%
			String coverImageURL = entry.getCoverImageURL(themeDisplay);
			%>

			<c:if test="<%= Validator.isNotNull(coverImageURL) %>">
				<div class="aspect-ratio aspect-ratio-8-to-3 aspect-ratio-bg-cover cover-image" style="background-image: url(<%= coverImageURL %>);"></div>
			</c:if>

			<%= entry.getContent() %>
		</div>

		<liferay-expando:custom-attributes-available
			className="<%= BlogsEntry.class.getName() %>"
		>
			<liferay-expando:custom-attribute-list
				className="<%= BlogsEntry.class.getName() %>"
				classPK="<%= (entry != null) ? entry.getEntryId() : 0 %>"
				editable="<%= false %>"
				label="<%= true %>"
			/>
		</liferay-expando:custom-attributes-available>
	</div>
</div>

<liferay-util:dynamic-include key="com.liferay.blogs.web#/blogs/asset/full_content.jsp#post" />