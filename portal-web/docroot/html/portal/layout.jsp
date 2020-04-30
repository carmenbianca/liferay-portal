<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
StringBundler sb = (StringBundler)request.getAttribute(WebKeys.LAYOUT_CONTENT);

sb.writeTo(out);

request.removeAttribute(WebKeys.LAYOUT_CONTENT);
%>