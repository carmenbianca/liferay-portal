<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/blogs/info/item/renderer/init.jsp" %>

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
	</div>
</div>