/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.custom.facet.display.context;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.search.web.internal.custom.facet.configuration.CustomFacetPortletInstanceConfiguration;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wade Cao
 */
public class CustomFacetDisplayContext {

	public CustomFacetDisplayContext(HttpServletRequest httpServletRequest)
		throws ConfigurationException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		_themeDisplay = themeDisplay;

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		_customFacetPortletInstanceConfiguration =
			portletDisplay.getPortletInstanceConfiguration(
				CustomFacetPortletInstanceConfiguration.class);
	}

	public CustomFacetPortletInstanceConfiguration
		getCustomFacetPortletInstanceConfiguration() {

		return _customFacetPortletInstanceConfiguration;
	}

	public String getDisplayCaption() {
		return _displayCaption;
	}

	public long getDisplayStyleGroupId() {
		if (_displayStyleGroupId != 0) {
			return _displayStyleGroupId;
		}

		_displayStyleGroupId =
			_customFacetPortletInstanceConfiguration.displayStyleGroupId();

		if (_displayStyleGroupId <= 0) {
			_displayStyleGroupId = _themeDisplay.getScopeGroupId();
		}

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

	public List<CustomFacetTermDisplayContext> getTermDisplayContexts() {
		return _customFacetTermDisplayContexts;
	}

	public boolean isNothingSelected() {
		return _nothingSelected;
	}

	public boolean isRenderNothing() {
		return _renderNothing;
	}

	public void setDisplayCaption(String displayCaption) {
		_displayCaption = displayCaption;
	}

	public void setNothingSelected(boolean nothingSelected) {
		_nothingSelected = nothingSelected;
	}

	public void setParameterName(String paramName) {
		_parameterName = paramName;
	}

	public void setParameterValue(String paramValue) {
		_parameterValue = paramValue;
	}

	public void setParameterValues(List<String> paramValues) {
		_parameterValues = paramValues;
	}

	public void setRenderNothing(boolean renderNothing) {
		_renderNothing = renderNothing;
	}

	public void setTermDisplayContexts(
		List<CustomFacetTermDisplayContext> customFacetTermDisplayContexts) {

		_customFacetTermDisplayContexts = customFacetTermDisplayContexts;
	}

	private final CustomFacetPortletInstanceConfiguration
		_customFacetPortletInstanceConfiguration;
	private List<CustomFacetTermDisplayContext> _customFacetTermDisplayContexts;
	private String _displayCaption;
	private long _displayStyleGroupId;
	private boolean _nothingSelected;
	private String _parameterName;
	private String _parameterValue;
	private List<String> _parameterValues;
	private boolean _renderNothing;
	private final ThemeDisplay _themeDisplay;

}