<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String mapProviderKey = (String)request.getAttribute(MapProviderWebKeys.MAP_PROVIDER_KEY);
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="maps"
/>

<liferay-map:map-provider-selector
	mapProviderKey="<%= mapProviderKey %>"
	name='<%= "TypeSettingsProperties--" + MapProviderWebKeys.MAP_PROVIDER_KEY + "--" %>'
/>