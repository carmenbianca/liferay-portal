<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/common/forward_common.jsp" %>

<script type="text/javascript">

	<%
	forwardURL = HtmlUtil.escapeJSLink(forwardURL);

	forwardURL = HtmlUtil.escapeJS(forwardURL);
	%>

	location.href = '<%= forwardURL %>';
</script>