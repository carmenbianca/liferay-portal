<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<portlet:defineObjects />

<%
renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
%>

<div class="alert alert-info">
	<liferay-ui:message key="this-portlet-could-not-be-found.-please-redeploy-it-or-remove-it-from-the-page" />
</div>