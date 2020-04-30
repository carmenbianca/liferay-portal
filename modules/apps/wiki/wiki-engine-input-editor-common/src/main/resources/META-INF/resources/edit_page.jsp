<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BaseWikiEngine baseWikiEngine = BaseWikiEngine.getBaseWikiEngine(request);

WikiNode node = BaseWikiEngine.getWikiNode(request);
WikiPage wikiPage = BaseWikiEngine.getWikiPage(request);

String content = BeanParamUtil.getString(wikiPage, request, "content");
%>

<div class="wiki-page-editor">
	<%@ include file="/editor_config.jspf" %>

	<liferay-editor:editor
		configParams="<%= configParams %>"
		contents="<%= content %>"
		editorName="<%= baseWikiEngine.getEditorName() %>"
		fileBrowserParams="<%= fileBrowserParams %>"
		name="contentEditor"
		placeholder="content"
		toolbarSet="<%= baseWikiEngine.getToolbarSet() %>"
	/>

	<aui:input name="content" type="hidden" />

	<c:if test="<%= baseWikiEngine.isHelpPageDefined() %>">
		<div align="right">
			<a href="javascript:;" id="<%= renderResponse.getNamespace() + "toggle_id_wiki_editor_help" %>"><liferay-ui:message key="show-syntax-help" /> &raquo;</a>
		</div>

		<%
		String helpPageHTML = baseWikiEngine.getHelpPageHTML(pageContext);
		String helpPageTitle = baseWikiEngine.getHelpPageTitle(request);
		%>

		<aui:script use="liferay-util-window">
			var helpPageLink = A.one(
				'#<%= renderResponse.getNamespace() + "toggle_id_wiki_editor_help" %>'
			);

			helpPageLink.on('click', function(event) {
				event.preventDefault();

				var helpPageDialog = Liferay.Util.Window.getWindow({
					dialog: {
						bodyContent: '<%= HtmlUtil.escapeJS(helpPageHTML) %>',
						destroyOnHide: true,
					},
					title: '<%= HtmlUtil.escapeJS(helpPageTitle) %>',
				});

				helpPageDialog.render();
			});
		</aui:script>
	</c:if>
</div>