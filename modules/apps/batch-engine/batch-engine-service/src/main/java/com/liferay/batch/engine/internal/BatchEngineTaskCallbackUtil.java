/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.internal;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * @author Ivica Cardic
 */
public class BatchEngineTaskCallbackUtil {

	public static void sendCallback(
		String callbackURL, String executeStatus, long id) {

		if (Validator.isBlank(callbackURL)) {
			return;
		}

		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

		try (CloseableHttpClient closeableHttpClient =
				httpClientBuilder.useSystemProperties(
				).build()) {

			HttpPost httpPost = new HttpPost(callbackURL);

			httpPost.setEntity(
				new StringEntity(
					_objectMapper.writeValueAsString(
						Collections.singletonMap(id, executeStatus)),
					ContentType.APPLICATION_JSON));

			closeableHttpClient.execute(httpPost);
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BatchEngineTaskCallbackUtil.class);

	private static final ObjectMapper _objectMapper = new ObjectMapper();

}