<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ page session="false" %>

<%
pageContext.setAttribute(WebKeys.THEME_DEFINE_OBJECTS, Boolean.FALSE);
%>

<%@ include file="/html/common/referer_common.jsp" %>

<script type="text/javascript">

	<%
	Boolean logout = (Boolean)request.getAttribute(WebKeys.LOGOUT);

	if (logout == null) {
		logout = Boolean.FALSE;
	}
	%>

	<c:if test="<%= logout && BrowserSnifferUtil.isIe(request) && PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(), PropsKeys.NTLM_AUTH_ENABLED, PropsValues.NTLM_AUTH_ENABLED) %>">
		document.execCommand('ClearAuthenticationCache');
	</c:if>

	<%
	referer = HtmlUtil.escapeJSLink(referer);

	referer = HtmlUtil.escapeJS(referer);
	%>

	location.href = '<%= referer %>';
</script>