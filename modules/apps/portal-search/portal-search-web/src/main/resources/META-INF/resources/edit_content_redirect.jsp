<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %>

<liferay-theme:defineObjects />

<%
String redirect = request.getParameter("redirect");

redirect = PortalUtil.escapeRedirect(redirect);
%>

<aui:script>
	var data = {
		id: '<portlet:namespace />editAsset',
		portletAjaxable: true,
	};

	<c:choose>
		<c:when test="<%= redirect != null %>">
			data.redirect = '<%= HtmlUtil.escapeJS(redirect) %>';
		</c:when>
		<c:otherwise>
			data.refresh = '<%= portletDisplay.getId() %>';
		</c:otherwise>
	</c:choose>

	Liferay.fire('closeWindow', data);
</aui:script>