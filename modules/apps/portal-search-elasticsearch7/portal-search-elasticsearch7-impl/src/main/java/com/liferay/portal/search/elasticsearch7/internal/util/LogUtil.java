/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.util;

import com.liferay.petra.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.search.elasticsearch7.configuration.RESTClientLoggerLevel;

import java.io.IOException;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.common.io.stream.OutputStreamStreamOutput;

/**
 * @author Michael C. Han
 */
public class LogUtil {

	public static void logActionResponse(
		Log log, ActionResponse actionResponse) {

		if (!log.isInfoEnabled()) {
			return;
		}

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		try {
			actionResponse.writeTo(
				new OutputStreamStreamOutput(unsyncByteArrayOutputStream));
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}

		String string = unsyncByteArrayOutputStream.toString();

		log.info(string.trim());
	}

	public static void logActionResponse(Log log, BulkResponse bulkResponse) {
		if (bulkResponse.hasFailures()) {
			log.error(bulkResponse.buildFailureMessage());
		}

		logActionResponse(log, (ActionResponse)bulkResponse);
	}

	public static void setRestClientLoggerLevel(
		RESTClientLoggerLevel restClientLoggerLevel) {

		org.apache.commons.logging.Log log = LogFactory.getLog(
			RestClient.class);

		if (log instanceof Log4JLogger) {
			Log4JLogger log4JLogger = (Log4JLogger)log;

			Logger logger = log4JLogger.getLogger();

			logger.setLevel(Level.toLevel(restClientLoggerLevel.name()));
		}
	}

}