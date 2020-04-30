/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.lar;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.model.LayoutSet;

/**
 * @author Matthew Tambara
 */
public interface ThemeImporter {

	public void importTheme(
			PortletDataContext portletDataContext, LayoutSet layoutSet)
		throws Exception;

}