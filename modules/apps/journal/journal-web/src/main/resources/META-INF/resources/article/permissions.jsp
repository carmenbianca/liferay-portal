<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="permissions"
/>

<aui:model-context bean="<%= journalDisplayContext.getArticle() %>" model="<%= JournalArticle.class %>" />

<liferay-ui:input-permissions
	modelName="<%= JournalArticle.class.getName() %>"
	reverse="<%= true %>"
/>