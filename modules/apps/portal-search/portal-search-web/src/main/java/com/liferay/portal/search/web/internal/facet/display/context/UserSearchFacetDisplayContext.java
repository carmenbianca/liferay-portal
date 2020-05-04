/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.context;

import com.liferay.portal.search.web.internal.user.facet.configuration.UserFacetPortletInstanceConfiguration;

import java.io.Serializable;

import java.util.List;

/**
 * @author Lino Alves
 */
public class UserSearchFacetDisplayContext implements Serializable {

	public long getDisplayStyleGroupId() {
		return _displayStyleGroupId;
	}

	public String getParamName() {
		return _paramName;
	}

	public String getParamValue() {
		return _paramValue;
	}

	public List<String> getParamValues() {
		return _paramValues;
	}

	public List<UserSearchFacetTermDisplayContext> getTermDisplayContexts() {
		return _userSearchFacetTermDisplayContexts;
	}

	public UserFacetPortletInstanceConfiguration
		getUserFacetPortletInstanceConfiguration() {

		return _userFacetPortletInstanceConfiguration;
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

	public void setParamName(String paramName) {
		_paramName = paramName;
	}

	public void setParamValue(String paramValue) {
		_paramValue = paramValue;
	}

	public void setParamValues(List<String> paramValues) {
		_paramValues = paramValues;
	}

	public void setRenderNothing(boolean renderNothing) {
		_renderNothing = renderNothing;
	}

	public void setTermDisplayContexts(
		List<UserSearchFacetTermDisplayContext>
			userSearchFacetTermDisplayContexts) {

		_userSearchFacetTermDisplayContexts =
			userSearchFacetTermDisplayContexts;
	}

	public void setUserFacetPortletInstanceConfiguration(
		UserFacetPortletInstanceConfiguration
			userFacetPortletInstanceConfiguration) {

		_userFacetPortletInstanceConfiguration =
			userFacetPortletInstanceConfiguration;
	}

	private long _displayStyleGroupId;
	private boolean _nothingSelected;
	private String _paramName;
	private String _paramValue;
	private List<String> _paramValues;
	private boolean _renderNothing;
	private UserFacetPortletInstanceConfiguration
		_userFacetPortletInstanceConfiguration;
	private List<UserSearchFacetTermDisplayContext>
		_userSearchFacetTermDisplayContexts;

}