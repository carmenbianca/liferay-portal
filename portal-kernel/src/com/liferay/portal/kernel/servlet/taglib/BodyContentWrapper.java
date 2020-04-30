/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib;

import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Raymond Augé
 */
public interface BodyContentWrapper {

	public StringBundler getStringBundler();

}