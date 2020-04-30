<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String mapProviderKey = (String)request.getAttribute(MapProviderWebKeys.MAP_PROVIDER_KEY);
%>

<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

<liferay-map:map-provider-selector
	configurationPrefix="settings"
	mapProviderKey="<%= mapProviderKey %>"
	name='<%= "settings--" + MapProviderWebKeys.MAP_PROVIDER_KEY + "--" %>'
/>