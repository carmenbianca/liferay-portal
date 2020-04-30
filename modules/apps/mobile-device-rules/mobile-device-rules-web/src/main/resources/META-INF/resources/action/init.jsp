<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
MDRAction action = (MDRAction)request.getAttribute(MDRWebKeys.MOBILE_DEVICE_RULES_RULE_GROUP_ACTION);

UnicodeProperties typeSettingsProperties = null;

if (action != null) {
	typeSettingsProperties = action.getTypeSettingsProperties();
}
else {
	typeSettingsProperties = new UnicodeProperties();
}
%>