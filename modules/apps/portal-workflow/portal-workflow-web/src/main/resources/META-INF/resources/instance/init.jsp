<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %><%@
taglib uri="http://liferay.com/tld/comment" prefix="liferay-comment" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil" %><%@
page import="com.liferay.asset.kernel.model.AssetEntry" %><%@
page import="com.liferay.asset.kernel.model.AssetRenderer" %><%@
page import="com.liferay.asset.kernel.model.AssetRendererFactory" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowException" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowInstance" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowLog" %><%@
page import="com.liferay.portal.workflow.web.internal.dao.search.WorkflowInstanceResultRowSplitter" %><%@
page import="com.liferay.portal.workflow.web.internal.display.context.MyWorkflowInstanceEditDisplayContext" %><%@
page import="com.liferay.portal.workflow.web.internal.display.context.MyWorkflowInstanceViewDisplayContext" %><%@
page import="com.liferay.portal.workflow.web.internal.display.context.WorkflowInstanceEditDisplayContext" %><%@
page import="com.liferay.portal.workflow.web.internal.display.context.WorkflowInstanceViewDisplayContext" %><%@
page import="com.liferay.taglib.search.DateSearchEntry" %><%@
page import="com.liferay.taglib.search.ResultRow" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<%
WorkflowInstanceViewDisplayContext workflowInstanceViewDisplayContext = null;

if (portletName.equals(WorkflowPortletKeys.USER_WORKFLOW)) {
	workflowInstanceViewDisplayContext = new MyWorkflowInstanceViewDisplayContext(liferayPortletRequest, liferayPortletResponse);
}
else {
	workflowInstanceViewDisplayContext = new WorkflowInstanceViewDisplayContext(liferayPortletRequest, liferayPortletResponse);
}
%>

<%@ include file="/instance/init-ext.jsp" %>