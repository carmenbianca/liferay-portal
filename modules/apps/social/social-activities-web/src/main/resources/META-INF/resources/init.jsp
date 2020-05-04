<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/rss" prefix="liferay-rss" %><%@
taglib uri="http://liferay.com/tld/social-activities" prefix="liferay-social-activities" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.social.activities.web.internal.constants.SocialActivitiesWebKeys" %><%@
page import="com.liferay.social.activities.web.internal.portlet.display.context.DefaultSocialActivitiesDisplayContext" %><%@
page import="com.liferay.social.activities.web.internal.portlet.display.context.SocialActivitiesDisplayContext" %><%@
page import="com.liferay.social.activities.web.internal.portlet.display.context.util.SocialActivitiesRequestHelper" %><%@
page import="com.liferay.social.activities.web.internal.util.SocialActivitiesQueryHelper" %>

<liferay-theme:defineObjects />

<%
SocialActivitiesRequestHelper socialActivitiesRequestHelper = new SocialActivitiesRequestHelper(request);
SocialActivitiesQueryHelper socialActivitiesQueryHelper = (SocialActivitiesQueryHelper)request.getAttribute(SocialActivitiesWebKeys.SOCIAL_ACTIVITIES_QUERY_HELPER);

SocialActivitiesDisplayContext socialActivitiesDisplayContext = new DefaultSocialActivitiesDisplayContext(socialActivitiesRequestHelper, socialActivitiesQueryHelper);
%>

<%@ include file="/init-ext.jsp" %>