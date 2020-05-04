<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-rss:rss-settings
	delta="<%= assetPublisherDisplayContext.getRSSDelta() %>"
	displayStyle="<%= assetPublisherDisplayContext.getRSSDisplayStyle() %>"
	displayStyles="<%= new String[] {RSSUtil.DISPLAY_STYLE_ABSTRACT, RSSUtil.DISPLAY_STYLE_TITLE} %>"
	enabled="<%= assetPublisherDisplayContext.isEnableRSS() %>"
	feedType="<%= assetPublisherDisplayContext.getRSSFeedType() %>"
	name="<%= assetPublisherDisplayContext.getRSSName() %>"
	nameEnabled="<%= true %>"
/>