/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.summary;

import java.util.Locale;

/**
 * @author André de Oliveira
 */
public interface Summary {

	public String getContent();

	public Locale getLocale();

	public String getTitle();

}