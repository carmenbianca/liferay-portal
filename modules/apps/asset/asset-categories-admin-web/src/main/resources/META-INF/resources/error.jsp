<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchCategoryException.class %>" message="the-category-could-not-be-found" />
<liferay-ui:error exception="<%= NoSuchVocabularyException.class %>" message="the-vocabulary-could-not-be-found" />

<liferay-ui:error-principal />