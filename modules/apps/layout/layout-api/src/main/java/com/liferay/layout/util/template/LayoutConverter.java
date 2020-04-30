/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.template;

import com.liferay.portal.kernel.model.Layout;

import java.util.Locale;

/**
 * @author Eudaldo Alonso
 */
public interface LayoutConverter {

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #convert(Layout, Locale)}
	 */
	@Deprecated
	public LayoutData convert(Layout layout);

	public default LayoutConversionResult convert(
		Layout layout, Locale locale) {

		return LayoutConversionResult.of(convert(layout), new String[0]);
	}

	public default boolean isConvertible(Layout layout) {
		if (layout.isTypeContent()) {
			return false;
		}

		return true;
	}

}