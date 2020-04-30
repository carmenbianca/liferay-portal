<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/search/init.jsp" %>

<%
PortletURL searchURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);

searchURL.setParameter("resetCur", Boolean.TRUE.toString());
%>

<aui:form action='<%= HttpUtil.removeParameter(searchURL.toString(), liferayPortletResponse.getNamespace() + "keywords") %>' name="searchFm">
	<liferay-ui:input-search
		markupView="lexicon"
	/>
</aui:form>