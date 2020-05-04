<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.search.web.internal.facet.display.context.ScopeSearchFacetDisplayContext" %><%@
page import="com.liferay.portal.search.web.internal.facet.display.context.ScopeSearchFacetTermDisplayContext" %><%@
page import="com.liferay.portal.search.web.internal.site.facet.configuration.SiteFacetPortletInstanceConfiguration" %><%@
page import="com.liferay.portal.search.web.internal.site.facet.portlet.SiteFacetPortletPreferences" %><%@
page import="com.liferay.portal.search.web.internal.site.facet.portlet.SiteFacetPortletPreferencesImpl" %><%@
page import="com.liferay.portal.search.web.internal.util.PortletPreferencesJspUtil" %>

<portlet:defineObjects />

<%
ScopeSearchFacetDisplayContext scopeSearchFacetDisplayContext = (ScopeSearchFacetDisplayContext)java.util.Objects.requireNonNull(request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT));

SiteFacetPortletInstanceConfiguration siteFacetPortletInstanceConfiguration = scopeSearchFacetDisplayContext.getSiteFacetPortletInstanceConfiguration();

SiteFacetPortletPreferences siteFacetPortletPreferences = new SiteFacetPortletPreferencesImpl(java.util.Optional.ofNullable(portletPreferences));
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<liferay-frontend:edit-form
	action="<%= configurationActionURL %>"
	method="post"
	name="fm"
>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<liferay-frontend:edit-form-body>
		<liferay-frontend:fieldset-group>
			<liferay-frontend:fieldset
				collapsible="<%= true %>"
				label="display-settings"
			>
				<div class="display-template">
					<liferay-ddm:template-selector
						className="<%= ScopeSearchFacetTermDisplayContext.class.getName() %>"
						displayStyle="<%= siteFacetPortletInstanceConfiguration.displayStyle() %>"
						displayStyleGroupId="<%= scopeSearchFacetDisplayContext.getDisplayStyleGroupId() %>"
						refreshURL="<%= configurationRenderURL %>"
						showEmptyOption="<%= true %>"
					/>
				</div>
			</liferay-frontend:fieldset>

			<liferay-frontend:fieldset
				collapsible="<%= true %>"
				label="advanced-configuration"
			>
				<aui:input label="site-parameter-name" name="<%= PortletPreferencesJspUtil.getInputName(SiteFacetPortletPreferences.PREFERENCE_KEY_PARAMETER_NAME) %>" value="<%= siteFacetPortletPreferences.getParameterName() %>" />

				<aui:input label="max-terms" name="<%= PortletPreferencesJspUtil.getInputName(SiteFacetPortletPreferences.PREFERENCE_KEY_MAX_TERMS) %>" value="<%= siteFacetPortletPreferences.getMaxTerms() %>" />

				<aui:input label="frequency-threshold" name="<%= PortletPreferencesJspUtil.getInputName(SiteFacetPortletPreferences.PREFERENCE_KEY_FREQUENCY_THRESHOLD) %>" value="<%= siteFacetPortletPreferences.getFrequencyThreshold() %>" />

				<aui:input label="display-frequencies" name="<%= PortletPreferencesJspUtil.getInputName(SiteFacetPortletPreferences.PREFERENCE_KEY_FREQUENCIES_VISIBLE) %>" type="checkbox" value="<%= siteFacetPortletPreferences.isFrequenciesVisible() %>" />
			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" />

		<aui:button type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>