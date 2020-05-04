/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.text.extractor;

import java.util.Locale;

/**
 * @author Alejandro Tardín
 */
public interface TextExtractor<T> {

	public String extract(T t, Locale locale);

	public String getClassName();

}