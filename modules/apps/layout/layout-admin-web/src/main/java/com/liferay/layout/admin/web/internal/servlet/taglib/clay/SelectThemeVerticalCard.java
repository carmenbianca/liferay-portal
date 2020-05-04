/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.VerticalCard;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.plugin.PluginPackage;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class SelectThemeVerticalCard implements VerticalCard {

	public SelectThemeVerticalCard(Theme theme, RenderRequest renderRequest) {
		_theme = theme;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
	}

	@Override
	public Map<String, String> getData() {
		return HashMapBuilder.put(
			"themeid", _theme.getThemeId()
		).build();
	}

	@Override
	public String getElementClasses() {
		return "card-img-align-top card-interactive " +
			"card-interactive-secondary selector-button";
	}

	@Override
	public String getImageSrc() {
		return _theme.getStaticResourcePath() + _theme.getImagesPath() +
			"/thumbnail.png";
	}

	@Override
	public String getSubtitle() {
		String author = StringPool.DASH;

		PluginPackage selPluginPackage = _theme.getPluginPackage();

		if ((selPluginPackage != null) &&
			Validator.isNotNull(selPluginPackage.getAuthor())) {

			author = LanguageUtil.format(
				_httpServletRequest, "by-x", selPluginPackage.getAuthor());
		}

		return author;
	}

	@Override
	public String getTitle() {
		return _theme.getName();
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	private final HttpServletRequest _httpServletRequest;
	private final Theme _theme;

}