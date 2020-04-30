<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/chart" prefix="chart" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.frontend.taglib.chart.sample.web.constants.ChartSamplePortletKeys" %><%@
page import="com.liferay.frontend.taglib.chart.sample.web.internal.display.context.ChartSampleDisplayContext" %>

<liferay-theme:defineObjects />

<%@ include file="/init-ext.jsp" %>

<%
ChartSampleDisplayContext chartSampleDisplayContext = (ChartSampleDisplayContext)request.getAttribute(ChartSamplePortletKeys.CHART_SAMPLE_DISPLAY_CONTEXT);
%>