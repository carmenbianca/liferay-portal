<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %><%@
page import="com.liferay.oauth2.provider.constants.ClientProfile" %><%@
page import="com.liferay.oauth2.provider.constants.GrantType" %><%@
page import="com.liferay.oauth2.provider.exception.DuplicateOAuth2ApplicationClientIdException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationClientCredentialUserIdException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationClientGrantTypeException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationHomePageURLException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationHomePageURLSchemeException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationNameException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationPrivacyPolicyURLException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationPrivacyPolicyURLSchemeException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationRedirectURIException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationRedirectURIFragmentException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationRedirectURIMissingException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationRedirectURIPathException" %><%@
page import="com.liferay.oauth2.provider.exception.OAuth2ApplicationRedirectURISchemeException" %><%@
page import="com.liferay.oauth2.provider.model.OAuth2Authorization" %><%@
page import="com.liferay.oauth2.provider.service.OAuth2AuthorizationServiceUtil" %><%@
page import="com.liferay.oauth2.provider.web.internal.AssignableScopes" %><%@
page import="com.liferay.oauth2.provider.web.internal.constants.OAuth2ProviderWebKeys" %><%@
page import="com.liferay.oauth2.provider.web.internal.display.context.AssignScopesDisplayContext" %><%@
page import="com.liferay.oauth2.provider.web.internal.display.context.OAuth2AdminPortletDisplayContext" %><%@
page import="com.liferay.oauth2.provider.web.internal.display.context.OAuth2ApplicationsManagementToolbarDisplayContext" %><%@
page import="com.liferay.oauth2.provider.web.internal.display.context.OAuth2AuthorizationsManagementToolbarDisplayContext" %><%@
page import="com.liferay.oauth2.provider.web.internal.display.context.SelectUsersDisplayContext" %><%@
page import="com.liferay.oauth2.provider.web.internal.display.context.SelectUsersManagementToolbarDisplayContext" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Collections" %><%@
page import="java.util.Date" %><%@
page import="java.util.HashSet" %><%@
page import="java.util.Iterator" %>

<%@ page import="javax.portlet.PortletURL" %>

<%
OAuth2AdminPortletDisplayContext oAuth2AdminPortletDisplayContext = (OAuth2AdminPortletDisplayContext)request.getAttribute(OAuth2ProviderWebKeys.OAUTH2_ADMIN_PORTLET_DISPLAY_CONTEXT);
%>