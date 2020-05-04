<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/definition_link/init.jsp" %>

<%
WorkflowDefinitionLinkDisplayTerms displayTerms = new WorkflowDefinitionLinkDisplayTerms(renderRequest);
%>

<liferay-ui:search-toggle
	autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>"
	buttonLabel="search"
	displayTerms="<%= displayTerms %>"
	id="toggle_id_workflow_definition_link_search"
	markupView="lexicon"
>
	<aui:fieldset>
		<aui:input inlineField="<%= true %>" name="<%= WorkflowDefinitionLinkDisplayTerms.RESOURCE %>" size="20" type="text" value="<%= displayTerms.getResource() %>" />

		<aui:input inlineField="<%= true %>" name="<%= WorkflowDefinitionLinkDisplayTerms.WORKFLOW %>" size="20" type="text" value="<%= displayTerms.getWorkflow() %>" />
	</aui:fieldset>
</liferay-ui:search-toggle>