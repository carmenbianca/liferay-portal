<%--
/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ page session="false" %>

<%@ include file="/html/common/referer_common.jsp" %>

<%
response.sendRedirect(referer);
%>