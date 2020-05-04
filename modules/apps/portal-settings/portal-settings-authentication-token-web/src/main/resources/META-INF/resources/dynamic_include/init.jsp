<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil" %><%@
page import="com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator" %><%@
page import="com.liferay.portal.kernel.settings.ParameterMapSettingsLocator" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.security.sso.token.configuration.TokenConfiguration" %><%@
page import="com.liferay.portal.security.sso.token.constants.TokenConfigurationKeys" %><%@
page import="com.liferay.portal.security.sso.token.constants.TokenConstants" %><%@
page import="com.liferay.portal.security.sso.token.security.auth.TokenLocation" %><%@
page import="com.liferay.portal.settings.authentication.token.web.internal.constants.PortalSettingsTokenConstants" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />