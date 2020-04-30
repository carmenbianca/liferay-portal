<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

JournalArticle article = (JournalArticle)row.getObject();

String href = (String)request.getAttribute(WebKeys.SEARCH_ENTRY_HREF);
%>

<aui:a href="<%= href %>" title="<%= HtmlUtil.escape(article.getTitle(locale)) %>">
	<%= HtmlUtil.escape(article.getTitle(locale)) %>
</aui:a>

<c:if test="<%= article.getGroupId() != scopeGroupId %>">
	<small class="group-info">
		<dl>

			<%
			Group group = GroupLocalServiceUtil.getGroup(article.getGroupId());
			%>

			<c:if test="<%= !group.isLayout() || (group.getParentGroupId() != scopeGroupId) %>">
				<dt>
					<liferay-ui:message key="site" />:
				</dt>
				<dd>

					<%
					String groupDescriptiveName = null;

					if (group.isLayout()) {
						Group parentGroup = group.getParentGroup();

						groupDescriptiveName = parentGroup.getDescriptiveName(locale);
					}
					else {
						groupDescriptiveName = group.getDescriptiveName(locale);
					}
					%>

					<%= HtmlUtil.escape(groupDescriptiveName) %>
				</dd>
			</c:if>

			<c:if test="<%= group.isLayout() %>">
				<dt>
					<liferay-ui:message key="scope" />:
				</dt>
				<dd>
					<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>
				</dd>
			</c:if>
		</dl>
	</small>
</c:if>