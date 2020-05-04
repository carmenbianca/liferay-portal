/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.modified.facet.display.context;

import com.liferay.portal.search.web.internal.modified.facet.configuration.ModifiedFacetPortletInstanceConfiguration;

import java.io.Serializable;

import java.util.List;

/**
 * @author Lino Alves
 */
public class ModifiedFacetDisplayContext implements Serializable {

	public ModifiedFacetTermDisplayContext
		getCustomRangeModifiedFacetTermDisplayContext() {

		return _customRangeModifiedFacetTermDisplayContext;
	}

	public ModifiedFacetTermDisplayContext
		getDefaultModifiedFacetTermDisplayContext() {

		return _defaultModifiedFacetTermDisplayContext;
	}

	public long getDisplayStyleGroupId() {
		return _displayStyleGroupId;
	}

	public ModifiedFacetCalendarDisplayContext
		getModifiedFacetCalendarDisplayContext() {

		return _modifiedFacetCalendarDisplayContext;
	}

	public ModifiedFacetPortletInstanceConfiguration
		getModifiedFacetPortletInstanceConfiguration() {

		return _modifiedFacetPortletInstanceConfiguration;
	}

	public List<ModifiedFacetTermDisplayContext>
		getModifiedFacetTermDisplayContexts() {

		return _modifiedFacetTermDisplayContexts;
	}

	public String getParameterName() {
		return _parameterName;
	}

	public boolean isNothingSelected() {
		return _nothingSelected;
	}

	public boolean isRenderNothing() {
		return _renderNothing;
	}

	public void setCalendarDisplayContext(
		ModifiedFacetCalendarDisplayContext
			modifiedFacetCalendarDisplayContext) {

		_modifiedFacetCalendarDisplayContext =
			modifiedFacetCalendarDisplayContext;
	}

	public void setCustomRangeModifiedFacetTermDisplayContext(
		ModifiedFacetTermDisplayContext customRangeTermDisplayContext) {

		_customRangeModifiedFacetTermDisplayContext =
			customRangeTermDisplayContext;
	}

	public void setDefaultModifiedFacetTermDisplayContext(
		ModifiedFacetTermDisplayContext defaultTermDisplayContext) {

		_defaultModifiedFacetTermDisplayContext = defaultTermDisplayContext;
	}

	public void setDisplayStyleGroupId(long displayStyleGroupId) {
		_displayStyleGroupId = displayStyleGroupId;
	}

	public void setModifiedFacetPortletInstanceConfiguration(
		ModifiedFacetPortletInstanceConfiguration
			modifiedFacetPortletInstanceConfiguration) {

		_modifiedFacetPortletInstanceConfiguration =
			modifiedFacetPortletInstanceConfiguration;
	}

	public void setModifiedFacetTermDisplayContexts(
		List<ModifiedFacetTermDisplayContext>
			modifiedFacetTermDisplayContexts) {

		_modifiedFacetTermDisplayContexts = modifiedFacetTermDisplayContexts;
	}

	public void setNothingSelected(boolean nothingSelected) {
		_nothingSelected = nothingSelected;
	}

	public void setParameterName(String paramName) {
		_parameterName = paramName;
	}

	public void setRenderNothing(boolean renderNothing) {
		_renderNothing = renderNothing;
	}

	private ModifiedFacetTermDisplayContext
		_customRangeModifiedFacetTermDisplayContext;
	private ModifiedFacetTermDisplayContext
		_defaultModifiedFacetTermDisplayContext;
	private long _displayStyleGroupId;
	private ModifiedFacetCalendarDisplayContext
		_modifiedFacetCalendarDisplayContext;
	private ModifiedFacetPortletInstanceConfiguration
		_modifiedFacetPortletInstanceConfiguration;
	private List<ModifiedFacetTermDisplayContext>
		_modifiedFacetTermDisplayContexts;
	private boolean _nothingSelected;
	private String _parameterName;
	private boolean _renderNothing;

}