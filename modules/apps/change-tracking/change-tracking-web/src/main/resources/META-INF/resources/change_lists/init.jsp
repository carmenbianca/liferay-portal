<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ChangeListsDisplayContext changeListsDisplayContext = (ChangeListsDisplayContext)request.getAttribute(CTWebKeys.CHANGE_LISTS_DISPLAY_CONTEXT);

CTDisplayRendererRegistry ctDisplayRendererRegistry = changeListsDisplayContext.getCtDisplayRendererRegistry();
%>