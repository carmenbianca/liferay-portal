<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
boolean groupMentionsEnabled = GetterUtil.getBoolean(request.getAttribute(MentionsWebKeys.GROUP_MENTIONS_ENABLED));
%>

<aui:input checked="<%= groupMentionsEnabled %>" label='<%= LanguageUtil.get(resourceBundle, "allow-users-to-mention-other-users") %>' name="TypeSettingsProperties--mentionsEnabled--" type="toggle-switch" value="<%= groupMentionsEnabled %>" />