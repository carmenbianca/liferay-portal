<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-util:include page="/color_picker_input.jsp" servletContext="<%= application %>">
	<liferay-util:param name="color" value="<%= portletConfigurationCSSPortletDisplayContext.getBackgroundColor() %>" />
	<liferay-util:param name="label" value='<%= LanguageUtil.get(request, "background-color") %>' />
	<liferay-util:param name="name" value='<%= renderResponse.getNamespace() + "backgroundColor" %>' />
</liferay-util:include>