<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/social_bookmark/init.jsp" %>

<script src="<%= HttpUtil.getProtocol(request) %>://static.evernote.com/noteit.js" type="text/javascript"></script>

<a href="#" onClick="Evernote.doClip({contentId:'<%= namespace + contentId %>', title:'<%= HtmlUtil.escapeJS(title) %>'}); return false;"><img alt="<liferay-ui:message escapeAttribute="<%= true %>" key="clip-to-evernote" />" src="<%= HttpUtil.getProtocol(request) %>://static.evernote.com/article-clipper.png" /></a>