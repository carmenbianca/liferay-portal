/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.custom.filter.display.context;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.search.web.internal.custom.filter.configuration.CustomFilterPortletInstanceConfiguration;
import com.liferay.portal.search.web.internal.util.SearchOptionalUtil;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author André de Oliveira
 */
public class CustomFilterDisplayBuilder {

	public static CustomFilterDisplayBuilder builder() {
		return new CustomFilterDisplayBuilder();
	}

	public CustomFilterDisplayContext build() throws ConfigurationException {
		CustomFilterDisplayContext customFilterDisplayContext =
			new CustomFilterDisplayContext();

		customFilterDisplayContext.setCustomFilterPortletInstanceConfiguration(
			getCustomFilterPortletInstanceConfiguration());
		customFilterDisplayContext.setDisplayStyleGroupId(
			getDisplayStyleGroupId());
		customFilterDisplayContext.setFilterValue(getFilterValue());
		customFilterDisplayContext.setHeading(getHeading());
		customFilterDisplayContext.setImmutable(_immutable);
		customFilterDisplayContext.setParameterName(_parameterName);
		customFilterDisplayContext.setRenderNothing(isRenderNothing());
		customFilterDisplayContext.setSearchURL(getURLCurrentPath());

		return customFilterDisplayContext;
	}

	public CustomFilterDisplayBuilder customHeadingOptional(
		Optional<String> customHeadingOptional) {

		_customHeadingOptional = customHeadingOptional;

		return this;
	}

	public CustomFilterDisplayBuilder disabled(boolean disabled) {
		_disabled = disabled;

		return this;
	}

	public CustomFilterDisplayBuilder filterFieldOptional(
		Optional<String> filterFieldOptional) {

		_filterFieldOptional = filterFieldOptional;

		return this;
	}

	public CustomFilterDisplayBuilder filterValueOptional(
		Optional<String> filterValueOptional) {

		_filterValueOptional = filterValueOptional;

		return this;
	}

	public CustomFilterDisplayBuilder http(Http http) {
		_http = http;

		return this;
	}

	public CustomFilterDisplayBuilder immutable(boolean immutable) {
		_immutable = immutable;

		return this;
	}

	public CustomFilterDisplayBuilder parameterName(String parameterName) {
		_parameterName = parameterName;

		return this;
	}

	public CustomFilterDisplayBuilder parameterValueOptional(
		Optional<String> parameterValueOptional) {

		_parameterValueOptional = parameterValueOptional;

		return this;
	}

	public CustomFilterDisplayBuilder queryNameOptional(
		Optional<String> queryNameOptional) {

		_queryNameOptional = queryNameOptional;

		return this;
	}

	public CustomFilterDisplayBuilder renderNothing(boolean renderNothing) {
		_renderNothing = renderNothing;

		return this;
	}

	public CustomFilterDisplayBuilder themeDisplay(ThemeDisplay themeDisplay) {
		_themeDisplay = themeDisplay;

		return this;
	}

	protected CustomFilterPortletInstanceConfiguration
			getCustomFilterPortletInstanceConfiguration()
		throws ConfigurationException {

		PortletDisplay portletDisplay = _themeDisplay.getPortletDisplay();

		return portletDisplay.getPortletInstanceConfiguration(
			CustomFilterPortletInstanceConfiguration.class);
	}

	protected long getDisplayStyleGroupId() throws ConfigurationException {
		CustomFilterPortletInstanceConfiguration
			customFilterPortletInstanceConfiguration =
				getCustomFilterPortletInstanceConfiguration();

		long displayStyleGroupId =
			customFilterPortletInstanceConfiguration.displayStyleGroupId();

		if (displayStyleGroupId <= 0) {
			displayStyleGroupId = _themeDisplay.getScopeGroupId();
		}

		return displayStyleGroupId;
	}

	protected String getFilterValue() {
		if (_immutable) {
			return SearchOptionalUtil.findFirstPresent(
				Stream.of(_filterValueOptional), StringPool.BLANK);
		}

		return SearchOptionalUtil.findFirstPresent(
			Stream.of(_parameterValueOptional, _filterValueOptional),
			StringPool.BLANK);
	}

	protected String getHeading() {
		return SearchOptionalUtil.findFirstPresent(
			Stream.of(
				_customHeadingOptional, _queryNameOptional,
				_filterFieldOptional),
			"custom");
	}

	protected String getURLCurrentPath() {
		if (_http == null) {
			return null;
		}

		return _http.getPath(_themeDisplay.getURLCurrent());
	}

	protected boolean isRenderNothing() {
		if (_disabled || _renderNothing) {
			return true;
		}

		return false;
	}

	private Optional<String> _customHeadingOptional = Optional.empty();
	private boolean _disabled;
	private Optional<String> _filterFieldOptional = Optional.empty();
	private Optional<String> _filterValueOptional = Optional.empty();
	private Http _http;
	private boolean _immutable;
	private String _parameterName;
	private Optional<String> _parameterValueOptional = Optional.empty();
	private Optional<String> _queryNameOptional = Optional.empty();
	private boolean _renderNothing;
	private ThemeDisplay _themeDisplay;

}