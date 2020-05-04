/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.test.CaptureHandler;
import com.liferay.portal.kernel.test.JDKLoggerTestUtil;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Wesley Gong
 */
@PrepareForTest(LanguageUtil.class)
@RunWith(PowerMockRunner.class)
public class LocaleUtilTest extends PowerMockito {

	@Test
	public void testFromLanguageId() {
		mockStatic(LanguageUtil.class);

		when(
			LanguageUtil.isAvailableLocale(Locale.US)
		).thenReturn(
			true
		);

		try (CaptureHandler captureHandler =
				JDKLoggerTestUtil.configureJDKLogger(
					LocaleUtil.class.getName(), Level.WARNING)) {

			List<LogRecord> logRecords = captureHandler.getLogRecords();

			Assert.assertEquals(Locale.US, LocaleUtil.fromLanguageId("en_US"));
			Assert.assertEquals(logRecords.toString(), 0, logRecords.size());

			logRecords.clear();

			LocaleUtil.fromLanguageId("en");

			Assert.assertEquals(logRecords.toString(), 1, logRecords.size());

			LogRecord logRecord = logRecords.get(0);

			Assert.assertEquals(
				"en is not a valid language id", logRecord.getMessage());
		}
	}

	@Test
	public void testFromLanguageIdBCP47() {
		mockStatic(LanguageUtil.class);

		when(
			LanguageUtil.isAvailableLocale(Locale.US)
		).thenReturn(
			true
		);

		Assert.assertEquals(Locale.US, LocaleUtil.fromLanguageId("en-US"));

		when(
			LanguageUtil.isAvailableLocale(Locale.SIMPLIFIED_CHINESE)
		).thenReturn(
			true
		);

		Assert.assertEquals(
			Locale.SIMPLIFIED_CHINESE, LocaleUtil.fromLanguageId("zh-Hans-CN"));

		when(
			LanguageUtil.isAvailableLocale(Locale.TRADITIONAL_CHINESE)
		).thenReturn(
			true
		);

		Assert.assertEquals(
			Locale.TRADITIONAL_CHINESE,
			LocaleUtil.fromLanguageId("zh-Hant-TW"));
	}

}