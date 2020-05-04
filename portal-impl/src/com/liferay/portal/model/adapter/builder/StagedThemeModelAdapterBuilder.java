/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.adapter.builder;

import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.model.adapter.StagedTheme;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;
import com.liferay.portal.model.adapter.impl.StagedThemeImpl;

/**
 * @author Máté Thurzó
 */
public class StagedThemeModelAdapterBuilder
	implements ModelAdapterBuilder<Theme, StagedTheme> {

	@Override
	public StagedTheme build(Theme theme) {
		return new StagedThemeImpl(theme);
	}

}