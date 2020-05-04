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
page import="com.liferay.portal.search.web.internal.category.facet.configuration.CategoryFacetPortletInstanceConfiguration" %><%@
page import="com.liferay.portal.search.web.internal.category.facet.portlet.CategoryFacetPortletPreferences" %><%@
page import="com.liferay.portal.search.web.internal.category.facet.portlet.CategoryFacetPortletPreferencesImpl" %><%@
page import="com.liferay.portal.search.web.internal.facet.display.context.AssetCategoriesSearchFacetDisplayContext" %><%@
page import="com.liferay.portal.search.web.internal.facet.display.context.AssetCategoriesSearchFacetTermDisplayContext" %><%@
page import="com.liferay.portal.search.web.internal.util.PortletPreferencesJspUtil" %>

<portlet:defineObjects />

<%
AssetCategoriesSearchFacetDisplayContext assetCategoriesSearchFacetDisplayContext = new AssetCategoriesSearchFacetDisplayContext(request);

CategoryFacetPortletInstanceConfiguration
	categoryFacetPortletInstanceConfiguration = assetCategoriesSearchFacetDisplayContext.getCategoryFacetPortletInstanceConfiguration();

CategoryFacetPortletPreferences categoryFacetPortletPreferences = new CategoryFacetPortletPreferencesImpl(java.util.Optional.ofNullable(portletPreferences));
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
						className="<%= AssetCategoriesSearchFacetTermDisplayContext.class.getName() %>"
						displayStyle="<%= categoryFacetPortletInstanceConfiguration.displayStyle() %>"
						displayStyleGroupId="<%= assetCategoriesSearchFacetDisplayContext.getDisplayStyleGroupId() %>"
						refreshURL="<%= configurationRenderURL %>"
						showEmptyOption="<%= true %>"
					/>
				</div>
			</liferay-frontend:fieldset>

			<liferay-frontend:fieldset
				collapsible="<%= true %>"
				label="advanced-configuration"
			>
				<aui:input label="category-parameter-name" name="<%= PortletPreferencesJspUtil.getInputName(CategoryFacetPortletPreferences.PREFERENCE_KEY_PARAMETER_NAME) %>" value="<%= categoryFacetPortletPreferences.getParameterName() %>" />

				<aui:input label="max-terms" name="<%= PortletPreferencesJspUtil.getInputName(CategoryFacetPortletPreferences.PREFERENCE_KEY_MAX_TERMS) %>" value="<%= categoryFacetPortletPreferences.getMaxTerms() %>" />

				<aui:input label="frequency-threshold" name="<%= PortletPreferencesJspUtil.getInputName(CategoryFacetPortletPreferences.PREFERENCE_KEY_FREQUENCY_THRESHOLD) %>" value="<%= categoryFacetPortletPreferences.getFrequencyThreshold() %>" />

				<aui:input label="display-frequencies" name="<%= PortletPreferencesJspUtil.getInputName(CategoryFacetPortletPreferences.PREFERENCE_KEY_FREQUENCIES_VISIBLE) %>" type="checkbox" value="<%= categoryFacetPortletPreferences.isFrequenciesVisible() %>" />
			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" />

		<aui:button type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>