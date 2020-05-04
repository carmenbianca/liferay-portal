<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowDefinition" %><%@
page import="com.liferay.portal.workflow.web.internal.display.context.WorkflowDefinitionLinkDisplayContext" %><%@
page import="com.liferay.portal.workflow.web.internal.search.WorkflowDefinitionLinkDisplayTerms" %><%@
page import="com.liferay.portal.workflow.web.internal.search.WorkflowDefinitionLinkSearchEntry" %>

<%@ page import="java.util.Map" %>

<%@ page import="javax.portlet.WindowState" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<%
WorkflowDefinitionLinkDisplayContext workflowDefinitionLinkDisplayContext = (WorkflowDefinitionLinkDisplayContext)renderRequest.getAttribute(WorkflowWebKeys.WORKFLOW_DEFINITION_LINK_DISPLAY_CONTEXT);
%>

<%@ include file="/definition_link/init-ext.jsp" %>