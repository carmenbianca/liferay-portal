/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.control.menu.web.internal.servlet.taglib.clay;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.frontend.taglib.clay.servlet.taglib.soy.HorizontalCard;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author Eudaldo Alonso
 */
public class AssetRendererHorizontalCard implements HorizontalCard {

	public AssetRendererHorizontalCard(
		AssetRenderer assetRenderer,
		LiferayPortletRequest liferayPortletRequest) {

		_assetRenderer = assetRenderer;

		_themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	@Override
	public String getElementClasses() {
		return "card-interactive card-interactive-secondary";
	}

	@Override
	public String getIcon() {
		try {
			return _assetRenderer.getIconCssClass();
		}
		catch (Exception exception) {
		}

		return null;
	}

	@Override
	public String getTitle() {
		String title = _assetRenderer.getTitle(_themeDisplay.getLocale());

		return HtmlUtil.escape(StringUtil.shorten(title, 60));
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	private final AssetRenderer _assetRenderer;
	private final ThemeDisplay _themeDisplay;

}