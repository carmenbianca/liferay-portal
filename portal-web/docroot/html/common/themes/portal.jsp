<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/common/themes/init.jsp" %>

<%
StringBundler sb = (StringBundler)request.getAttribute(WebKeys.LAYOUT_CONTENT);

if ((sb != null) && themeDisplay.isStateExclusive()) {
	sb.writeTo(out);
}
else {
	Definition definition = (Definition)request.getAttribute(TilesUtil.DEFINITION);

	boolean tilesPopUp = false;

	if (definition != null) {
		Map<String, String> attributes = definition.getAttributes();

		tilesPopUp = GetterUtil.getBoolean(attributes.get("pop_up"));
	}

	if (tilesPopUp || themeDisplay.isStatePopUp() || themeDisplay.isWidget()) {
%>

		<liferay-theme:include
			page="portal_pop_up.jsp"
		/>

	<%
	}
	else {
	%>

		<liferay-theme:include
			page="portal_normal.jsp"
		/>

<%
	}
}

request.removeAttribute(WebKeys.LAYOUT_CONTENT);

PortalMessages.clear(request);
SessionMessages.clear(request);
SessionErrors.clear(request);
%>