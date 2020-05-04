/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.taglib.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.VerticalCard;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class SiteVerticalCard implements VerticalCard {

	public SiteVerticalCard(
		Group group, RenderRequest renderRequest, long[] selectedGroupIds) {

		_group = group;
		_selectedGroupIds = selectedGroupIds;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		_themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	@Override
	public Map<String, String> getData() {
		Map<String, String> data = new HashMap<>();

		try {
			data.put(
				"groupdescriptivename",
				_group.getDescriptiveName(_themeDisplay.getLocale()));
			data.put("groupid", String.valueOf(_group.getGroupId()));
			data.put(
				"groupscopelabel",
				LanguageUtil.get(
					_httpServletRequest, _group.getScopeLabel(_themeDisplay)));
			data.put(
				"grouptype",
				LanguageUtil.get(_httpServletRequest, _group.getTypeLabel()));
			data.put("url", _group.getDisplayURL(_themeDisplay));
			data.put("uuid", _group.getUuid());
		}
		catch (Exception exception) {
		}

		return data;
	}

	@Override
	public String getElementClasses() {
		if (ArrayUtil.contains(_selectedGroupIds, _group.getGroupId())) {
			return "text-muted";
		}

		return "card-interactive card-interactive-secondary selector-button";
	}

	@Override
	public String getIcon() {
		return "sites";
	}

	@Override
	public String getImageSrc() {
		return _group.getLogoURL(_themeDisplay, false);
	}

	@Override
	public String getSubtitle() {
		return null;
	}

	@Override
	public String getTitle() {
		try {
			return HtmlUtil.escape(
				_group.getDescriptiveName(_themeDisplay.getLocale()));
		}
		catch (Exception exception) {
		}

		return null;
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	private final Group _group;
	private final HttpServletRequest _httpServletRequest;
	private final long[] _selectedGroupIds;
	private final ThemeDisplay _themeDisplay;

}