/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.context;

import com.liferay.portal.search.web.internal.tag.facet.configuration.TagFacetPortletInstanceConfiguration;

import java.util.List;

/**
 * @author André de Oliveira
 */
public class AssetTagsSearchFacetDisplayContext {

	public long getDisplayStyleGroupId() {
		return _displayStyleGroupId;
	}

	public String getFacetLabel() {
		return _facetLabel;
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

	public TagFacetPortletInstanceConfiguration
		getTagFacetPortletInstanceConfiguration() {

		return _tagFacetPortletInstanceConfiguration;
	}

	public List<AssetTagsSearchFacetTermDisplayContext>
		getTermDisplayContexts() {

		return _assetTagsSearchFacetTermDisplayContexts;
	}

	public boolean isCloudWithCount() {
		return _cloudWithCount;
	}

	public boolean isNothingSelected() {
		return _nothingSelected;
	}

	public boolean isRenderNothing() {
		return _renderNothing;
	}

	public void setCloudWithCount(boolean cloudWithCount) {
		_cloudWithCount = cloudWithCount;
	}

	public void setDisplayStyleGroupId(long displayStyleGroupId) {
		_displayStyleGroupId = displayStyleGroupId;
	}

	public void setFacetLabel(String facetLabel) {
		_facetLabel = facetLabel;
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

	public void setTagFacetPortletInstanceConfiguration(
		TagFacetPortletInstanceConfiguration
			tagFacetPortletInstanceConfiguration) {

		_tagFacetPortletInstanceConfiguration =
			tagFacetPortletInstanceConfiguration;
	}

	public void setTermDisplayContexts(
		List<AssetTagsSearchFacetTermDisplayContext>
			assetTagsSearchFacetTermDisplayContexts) {

		_assetTagsSearchFacetTermDisplayContexts =
			assetTagsSearchFacetTermDisplayContexts;
	}

	private List<AssetTagsSearchFacetTermDisplayContext>
		_assetTagsSearchFacetTermDisplayContexts;
	private boolean _cloudWithCount;
	private long _displayStyleGroupId;
	private String _facetLabel;
	private boolean _nothingSelected;
	private String _parameterName;
	private String _parameterValue;
	private List<String> _parameterValues;
	private boolean _renderNothing;
	private TagFacetPortletInstanceConfiguration
		_tagFacetPortletInstanceConfiguration;

}