<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Layout selLayout = (Layout)request.getAttribute(WebKeys.SEL_LAYOUT);

LinkToPageLayoutTypeControllerDisplayContext linkToPageLayoutTypeControllerDisplayContext = new LinkToPageLayoutTypeControllerDisplayContext(liferayPortletRequest, liferayPortletResponse);
%>