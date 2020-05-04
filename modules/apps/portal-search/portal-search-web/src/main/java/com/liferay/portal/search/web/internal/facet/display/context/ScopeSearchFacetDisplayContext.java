/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.context;

import com.liferay.portal.search.web.internal.site.facet.configuration.SiteFacetPortletInstanceConfiguration;

import java.util.List;

/**
 * @author André de Oliveira
 */
public class ScopeSearchFacetDisplayContext {

	public long getDisplayStyleGroupId() {
		return _displayStyleGroupId;
	}

	public String getParameterName() {
		return _parameterName;
	}

	public String getParameterValue() {
		return _parameterValue;
	}

	public List<String> getParameterValues() {
		return _parameterValues;
	}

	public SiteFacetPortletInstanceConfiguration
		getSiteFacetPortletInstanceConfiguration() {

		return _siteFacetPortletInstanceConfiguration;
	}

	public List<ScopeSearchFacetTermDisplayContext> getTermDisplayContexts() {
		return _scopeSearchFacetTermDisplayContexts;
	}

	public boolean isNothingSelected() {
		return _nothingSelected;
	}

	public boolean isRenderNothing() {
		return _renderNothing;
	}

	public void setDisplayStyleGroupId(long displayStyleGroupId) {
		_displayStyleGroupId = displayStyleGroupId;
	}

	public void setNothingSelected(boolean nothingSelected) {
		_nothingSelected = nothingSelected;
	}

	public void setParameterName(String parameterName) {
		_parameterName = parameterName;
	}

	public void setParameterValue(String parameterValue) {
		_parameterValue = parameterValue;
	}

	public void setParameterValues(List<String> parameterValues) {
		_parameterValues = parameterValues;
	}

	public void setRenderNothing(boolean renderNothing) {
		_renderNothing = renderNothing;
	}

	public void setSiteFacetPortletInstanceConfiguration(
		SiteFacetPortletInstanceConfiguration
			siteFacetPortletInstanceConfiguration) {

		_siteFacetPortletInstanceConfiguration =
			siteFacetPortletInstanceConfiguration;
	}

	public void setTermDisplayContexts(
		List<ScopeSearchFacetTermDisplayContext>
			scopeSearchFacetTermDisplayContexts) {

		_scopeSearchFacetTermDisplayContexts =
			scopeSearchFacetTermDisplayContexts;
	}

	private long _displayStyleGroupId;
	private boolean _nothingSelected;
	private String _parameterName;
	private String _parameterValue;
	private List<String> _parameterValues;
	private boolean _renderNothing;
	private List<ScopeSearchFacetTermDisplayContext>
		_scopeSearchFacetTermDisplayContexts;
	private SiteFacetPortletInstanceConfiguration
		_siteFacetPortletInstanceConfiguration;

}