<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/polls/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchQuestionException.class %>" message="the-question-could-not-be-found" />

<liferay-ui:error-principal />