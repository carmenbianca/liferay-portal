<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

WorkflowTask workflowTask = workflowTaskDisplayContext.getWorkflowTask();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(LanguageUtil.get(request, "usages") + ": " + workflowTaskDisplayContext.getAssetTitle(workflowTask));
%>

<liferay-layout:layout-classed-model-usages-admin
	className="<%= className %>"
	classPK="<%= classPK %>"
/>