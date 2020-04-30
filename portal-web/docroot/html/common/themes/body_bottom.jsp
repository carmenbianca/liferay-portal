<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/common/themes/init.jsp" %>

<%
com.liferay.petra.string.StringBundler bodyBottomSB = OutputTag.getDataSB(request, WebKeys.PAGE_BODY_BOTTOM);

if (bodyBottomSB != null) {
	bodyBottomSB.writeTo(out);
}
%>

<liferay-util:include page="/html/common/themes/body_bottom-ext.jsp" />