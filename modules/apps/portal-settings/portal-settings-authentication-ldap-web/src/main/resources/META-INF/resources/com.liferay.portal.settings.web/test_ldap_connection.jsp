<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/com.liferay.portal.settings.web/init.jsp" %>

<%
long ldapServerId = ParamUtil.getLong(request, "ldapServerId");

String baseProviderURL = ParamUtil.getString(request, "baseProviderURL");
String principal = ParamUtil.getString(request, "principal");

String credentials = request.getParameter("credentials");

if (credentials.equals(Portal.TEMP_OBFUSCATION_VALUE)) {
	LDAPServerConfiguration ldapServerConfiguration = ldapServerConfigurationProvider.getConfiguration(themeDisplay.getCompanyId(), ldapServerId);

	credentials = ldapServerConfiguration.securityCredential();
}

SafePortalLDAP safePortalLDAP = SafePortalLDAPUtil.getSafePortalLDAP();

SafeLdapContext safeLdapContext = safePortalLDAP.getSafeLdapContext(themeDisplay.getCompanyId(), baseProviderURL, principal, credentials);
%>

<c:choose>
	<c:when test="<%= safeLdapContext != null %>">
		<liferay-ui:message key="liferay-has-successfully-connected-to-the-ldap-server" />
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="liferay-has-failed-to-connect-to-the-ldap-server" />
	</c:otherwise>
</c:choose>

<%
if (safeLdapContext != null) {
	safeLdapContext.close();
}
%>