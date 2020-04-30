/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.util;

import java.util.Map;

/**
 * @author Matthew Tambara
 */
public interface SoyContextFactory {

	public SoyContext createSoyContext();

	public SoyContext createSoyContext(Map<String, Object> context);

}