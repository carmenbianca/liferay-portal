<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<%
PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

WikiNode node = (WikiNode)request.getAttribute(WikiWebKeys.WIKI_NODE);

WikiWebComponentProvider wikiWebComponentProvider = WikiWebComponentProvider.getWikiWebComponentProvider();

WikiGroupServiceConfiguration wikiGroupServiceConfiguration = wikiWebComponentProvider.getWikiGroupServiceConfiguration();

WikiRequestHelper wikiRequestHelper = new WikiRequestHelper(request);

WikiURLHelper wikiURLHelper = new WikiURLHelper(wikiRequestHelper, portletResponse, wikiGroupServiceConfiguration);

PortletURL searchURL = wikiURLHelper.getSearchURL();
%>

<aui:form action="<%= searchURL %>" method="get" name="searchFm">
	<liferay-portlet:renderURLParams portletURL="<%= searchURL %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="nodeId" type="hidden" value="<%= node.getNodeId() %>" />

	<liferay-ui:input-search
		id='<%= portletResponse.getNamespace() + "keywords1" %>'
		markupView="lexicon"
		name='<%= portletResponse.getNamespace() + "keywords" %>'
		useNamespace="<%= false %>"
	/>
</aui:form>