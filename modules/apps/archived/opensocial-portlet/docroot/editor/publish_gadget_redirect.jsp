<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long gadgetId = ParamUtil.getLong(request, "gadgetId");

boolean unpublishPermission = ParamUtil.getBoolean(request, "unpublishPermission");
%>

<aui:script use="aui-base">
	Liferay.Util.getOpener().Liferay.fire(
		'publishGadgetSuccess',
		{
			gadgetId: <%= gadgetId %>,
			unpublishPermission: <%= unpublishPermission %>
		}
	);
</aui:script>