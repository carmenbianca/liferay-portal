<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
BackgroundTask backgroundTask = (BackgroundTask)request.getAttribute("liferay-staging:process-info:backgroundTask");

String userName = LanguageUtil.get(request, "deleted-user");

User backgroundTaskUser = UserLocalServiceUtil.fetchUser(backgroundTask.getUserId());

if (backgroundTaskUser != null) {
	userName = backgroundTaskUser.getFullName();
}
%>