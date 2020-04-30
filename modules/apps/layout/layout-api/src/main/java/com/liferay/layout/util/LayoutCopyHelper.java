/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util;

import com.liferay.portal.kernel.model.Layout;

/**
 * @author Pavel Savinov
 */
public interface LayoutCopyHelper {

	public Layout copyLayout(Layout sourceLayout, Layout targetLayout)
		throws Exception;

}