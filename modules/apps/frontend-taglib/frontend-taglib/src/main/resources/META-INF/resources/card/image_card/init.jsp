<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-frontend:image-card:cssClass"));
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-frontend:image-card:data");
String imageCSSClass = GetterUtil.getString((String)request.getAttribute("liferay-frontend:image-card:imageCSSClass"));
String imageUrl = (String)request.getAttribute("liferay-frontend:image-card:imageUrl");
%>