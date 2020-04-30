<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:if test="<%= !layout.isTypeControlPanel() && !windowState.equals(LiferayWindowState.EXCLUSIVE) %>">
	<liferay-util:include page="/tabs1.jsp" servletContext="<%= application %>">
		<liferay-util:param name="tabs1" value="setup" />
	</liferay-util:include>
</c:if>

<div class="portlet-configuration-setup">

	<%
	ConfigurationAction configurationAction = (ConfigurationAction)request.getAttribute(WebKeys.CONFIGURATION_ACTION);

	if (configurationAction != null) {
		configurationAction.include(portletConfig, request, PipingServletResponse.createPipingServletResponse(pageContext));
	}
	%>

</div>