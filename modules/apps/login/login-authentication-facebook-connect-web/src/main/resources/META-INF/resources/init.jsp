<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.exception.UserEmailAddressException" %><%@
page import="com.liferay.portal.security.sso.facebook.connect.exception.MustVerifyEmailAddressException" %><%@
page import="com.liferay.portal.security.sso.facebook.connect.exception.StrangersNotAllowedException" %><%@
page import="com.liferay.portal.security.sso.facebook.connect.exception.UnknownErrorException" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />