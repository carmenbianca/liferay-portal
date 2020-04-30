<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<%
OpenIdConfiguration openIdConfiguration = ConfigurationProviderUtil.getConfiguration(OpenIdConfiguration.class, new ParameterMapSettingsLocator(request.getParameterMap(), PortalSettingsOpenIdConstants.FORM_PARAMETER_NAMESPACE, new CompanyServiceSettingsLocator(company.getCompanyId(), OpenIdConstants.SERVICE_NAME)));

boolean enabled = openIdConfiguration.enabled();
%>

<aui:fieldset>
	<aui:input label="enabled" name='<%= PortalSettingsOpenIdConstants.FORM_PARAMETER_NAMESPACE + "enabled" %>' type="checkbox" value="<%= enabled %>" />
</aui:fieldset>