<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/message_boards/init.jsp" %>

<%
MBMessage message = (MBMessage)request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE);

request.setAttribute("edit-message.jsp-showPermanentLink", Boolean.FALSE);
request.setAttribute("edit-message.jsp-showRecentPosts", Boolean.FALSE);
request.setAttribute("edit_message.jsp-category", message.getCategory());
request.setAttribute("edit_message.jsp-editable", Boolean.FALSE);
request.setAttribute("edit_message.jsp-message", message);
request.setAttribute("edit_message.jsp-thread", message.getThread());
%>

<liferay-util:include page="/message_boards/view_thread_message.jsp" servletContext="<%= application %>" />