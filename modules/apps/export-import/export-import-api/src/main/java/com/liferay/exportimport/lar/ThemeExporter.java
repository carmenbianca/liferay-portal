/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.lar;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.LayoutSetBranch;

/**
 * @author Matthew Tambara
 */
public interface ThemeExporter {

	public void exportTheme(
			PortletDataContext portletDataContext, LayoutSet layoutSet)
		throws Exception;

	public void exportTheme(
			PortletDataContext portletDataContext,
			LayoutSetBranch layoutSetBranch)
		throws Exception;

}