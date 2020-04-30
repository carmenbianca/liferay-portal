/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.renderer;

import com.liferay.fragment.constants.FragmentConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.io.IOException;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jorge Ferrer
 */
@ProviderType
public interface FragmentRenderer {

	public String getCollectionKey();

	public default String getConfiguration(
		FragmentRendererContext fragmentRendererContext) {

		return StringPool.BLANK;
	}

	public default String getImagePreviewURL(
		HttpServletRequest httpServletRequest) {

		return StringPool.BLANK;
	}

	public default String getKey() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}

	public default String getLabel(Locale locale) {
		return LanguageUtil.get(
			locale, FragmentConstants.getTypeLabel(getType()));
	}

	public default int getType() {
		return FragmentConstants.TYPE_COMPONENT;
	}

	public default boolean isSelectable(HttpServletRequest httpServletRequest) {
		return true;
	}

	public void render(
			FragmentRendererContext fragmentRendererContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException;

}