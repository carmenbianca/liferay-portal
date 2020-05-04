/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.frontend.js.minifier;

import com.liferay.portal.kernel.test.CaptureHandler;
import com.liferay.portal.kernel.test.JDKLoggerTestUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Iván Zaera Avellón
 */
public class GoogleJavascriptMinifierTest {

	@Test
	public void testMinifierCode() {
		GoogleJavaScriptMinifier googleJavaScriptMinifier =
			new GoogleJavaScriptMinifier();

		String code = "function(){ var invalidFunctionExpression; }";

		try (CaptureHandler captureHandler =
				JDKLoggerTestUtil.configureJDKLogger(
					GoogleJavaScriptMinifier.class.getName(), Level.SEVERE)) {

			String minifiedJS = googleJavaScriptMinifier.compress("test", code);

			Assert.assertEquals(44, minifiedJS.length());

			List<LogRecord> logRecords = captureHandler.getLogRecords();

			Assert.assertEquals(logRecords.toString(), 2, logRecords.size());

			LogRecord logRecord = logRecords.get(0);

			Assert.assertEquals(
				"(test:1): Parse error. 'identifier' expected " +
					"[JSC_PARSE_ERROR]",
				logRecord.getMessage());

			logRecord = logRecords.get(1);

			Assert.assertEquals(
				"(test): 1 error(s), 0 warning(s)", logRecord.getMessage());

			captureHandler.resetLogLevel(Level.SEVERE);
		}
	}

	@Test
	public void testMinifierSpaces() {
		GoogleJavaScriptMinifier googleJavaScriptMinifier =
			new GoogleJavaScriptMinifier();

		String code = " \t\r\n";

		String minifiedJS = googleJavaScriptMinifier.compress("test", code);

		Assert.assertEquals(0, minifiedJS.length());
	}

}