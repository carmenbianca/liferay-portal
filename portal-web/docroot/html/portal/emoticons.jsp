<%--
/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
String[][] emoticons = BBCodeTranslatorUtil.getEmoticons();

for (int i = 0; i < emoticons.length; i++) {
	String image = StringUtil.replace(emoticons[i][0], ThemeConstants.TOKEN_THEME_IMAGES_PATH, themeDisplay.getPathThemeImages());
%>

	<a class="emoticon lfr-button" emoticonCode="<%= emoticons[i][1] %>"><%= image %></a>

<%
}
%>