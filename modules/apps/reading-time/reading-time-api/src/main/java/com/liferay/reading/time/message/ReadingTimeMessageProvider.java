/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.message;

import com.liferay.reading.time.model.ReadingTimeEntry;

import java.time.Duration;

import java.util.Locale;

/**
 * @author Alejandro Tardín
 */
public interface ReadingTimeMessageProvider {

	public String provide(Duration readingTimeDuration, Locale locale);

	public String provide(ReadingTimeEntry readingTimeEntry, Locale locale);

}