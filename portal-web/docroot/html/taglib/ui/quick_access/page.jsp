<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/quick_access/init.jsp" %>

<%
String randomNamespace = StringUtil.randomId() + StringPool.UNDERLINE;
%>

<c:if test="<%= ((quickAccessEntries != null) && !quickAccessEntries.isEmpty()) || Validator.isNotNull(contentId) %>">
	<nav class="quick-access-nav" id="<%= randomNamespace + "quickAccessNav" %>">
		<h1 class="hide-accessible"><liferay-ui:message key="navigation" /></h1>

		<ul>
			<c:if test="<%= Validator.isNotNull(contentId) %>">
				<li><a href="<%= contentId %>"><liferay-ui:message key="skip-to-content" /></a></li>
			</c:if>

			<%
			if ((quickAccessEntries != null) && !quickAccessEntries.isEmpty()) {
				for (QuickAccessEntry quickAccessEntry : quickAccessEntries) {
			%>

					<li>
						<a href="<%= quickAccessEntry.getURL() %>" id="<%= randomNamespace + quickAccessEntry.getId() %>" onclick="<%= quickAccessEntry.getOnClick() %>">
							<%= quickAccessEntry.getContent() %>
						</a>
					</li>

			<%
				}
			}
			%>

		</ul>
	</nav>
</c:if>