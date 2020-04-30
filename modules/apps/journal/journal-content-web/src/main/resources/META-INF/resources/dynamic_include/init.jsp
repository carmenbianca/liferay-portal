<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.journal.constants.JournalContentPortletKeys" %><%@
page import="com.liferay.journal.content.web.internal.constants.JournalContentWebKeys" %><%@
page import="com.liferay.journal.content.web.internal.display.context.JournalContentDisplayContext" %><%@
page import="com.liferay.journal.content.web.internal.security.permission.resource.JournalArticlePermission" %><%@
page import="com.liferay.journal.model.JournalArticle" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="java.util.Map" %>

<liferay-theme:defineObjects />

<%
JournalContentDisplayContext journalContentDisplayContext = (JournalContentDisplayContext)request.getAttribute(JournalContentWebKeys.JOURNAL_CONTENT_DISPLAY_CONTEXT);
%>