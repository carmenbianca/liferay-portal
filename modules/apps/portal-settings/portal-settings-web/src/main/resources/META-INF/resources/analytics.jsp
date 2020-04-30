<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String adminAnalyticsTypes = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_ANALYTICS_TYPES);
%>

<aui:fieldset>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:input label="enter-one-analytics-system-name-per-line" name='<%= "settings--" + PropsKeys.ADMIN_ANALYTICS_TYPES + "--" %>' type="textarea" value="<%= adminAnalyticsTypes %>" />
</aui:fieldset>