/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.calculator;

import com.liferay.portal.kernel.model.GroupedModel;

import java.time.Duration;

import java.util.Locale;
import java.util.Optional;

/**
 * @author Alejandro Tardín
 */
public interface ReadingTimeCalculator {

	public Optional<Duration> calculate(GroupedModel groupedModel);

	public Optional<Duration> calculate(
		String content, String contentType, Locale locale);

}