<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchArticleException.class %>" message="the-web-content-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchStructureException.class %>" message="the-structure-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchTemplateException.class %>" message="the-template-could-not-be-found" />

<liferay-ui:error-principal />