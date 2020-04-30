<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/instance/init.jsp" %>

<%
DateSearchEntry dateSearchEntry = new DateSearchEntry();

String displayStyle = workflowInstanceViewDisplayContext.getDisplayStyle();

PortletURL portletURL = workflowInstanceViewDisplayContext.getViewPortletURL();
%>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<liferay-util:include page="/instance/toolbar.jsp" servletContext="<%= application %>" />
</aui:form>

<div class="container-fluid-1280 main-content-body workflow-instance-container">
	<%@ include file="/instance/workflow_instance.jspf" %>
</div>