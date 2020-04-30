<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String namespace = AUIUtil.getNamespace(liferayPortletRequest, liferayPortletResponse);

String name = (String)request.getAttribute("liferay-map:map:name");
MapProvider mapProvider = (MapProvider)request.getAttribute("liferay-map:map:mapProvider");

name = namespace + name;
%>