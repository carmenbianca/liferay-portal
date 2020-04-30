/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.index;

import com.liferay.portal.search.test.util.IdempotentRetryAssert;

import java.io.IOException;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsResponse.FieldMappingMetaData;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;

import org.junit.Assert;

/**
 * @author Artur Aquino
 * @author André de Oliveira
 */
public class FieldMappingAssert {

	public static void assertAnalyzer(
			String expectedValue, String field, String type, String index,
			IndicesClient indicesClient)
		throws Exception {

		assertFieldMappingMetaData(
			expectedValue, "analyzer", field, type, index, indicesClient);
	}

	public static void assertFieldMappingMetaData(
			final String expectedValue, final String key, final String field,
			final String type, final String index,
			final IndicesClient indicesClient)
		throws Exception {

		IdempotentRetryAssert.retryAssert(
			10, TimeUnit.SECONDS,
			new Callable<Void>() {

				@Override
				public Void call() throws Exception {
					doAssertFieldMappingMetaData(
						expectedValue, key, field, type, index, indicesClient);

					return null;
				}

			});
	}

	public static void assertType(
			String expectedValue, String field, String type, String index,
			IndicesClient indicesClient)
		throws Exception {

		assertFieldMappingMetaData(
			expectedValue, "type", field, type, index, indicesClient);
	}

	protected static void doAssertFieldMappingMetaData(
		String expectedValue, String key, String field, String type,
		String index, IndicesClient indicesClient) {

		FieldMappingMetaData fieldMappingMetaData = getFieldMapping(
			field, type, index, indicesClient);

		String value = getFieldMappingMetaDataValue(
			fieldMappingMetaData, field, key);

		Assert.assertEquals(expectedValue, value);
	}

	protected static FieldMappingMetaData getFieldMapping(
		String field, String type, String index, IndicesClient indicesClient) {

		GetFieldMappingsRequest getFieldMappingsRequest =
			new GetFieldMappingsRequest();

		getFieldMappingsRequest.fields(field);
		getFieldMappingsRequest.indices(index);
		getFieldMappingsRequest.types(type);

		try {
			GetFieldMappingsResponse getFieldMappingsResponse =
				indicesClient.getFieldMapping(
					getFieldMappingsRequest, RequestOptions.DEFAULT);

			return getFieldMappingsResponse.fieldMappings(index, type, field);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	@SuppressWarnings("unchecked")
	protected static String getFieldMappingMetaDataValue(
		FieldMappingMetaData fieldMappingMetaData, String field, String key) {

		Map<String, Object> mappings = fieldMappingMetaData.sourceAsMap();

		Map<String, Object> mapping = (Map<String, Object>)mappings.get(field);

		return (String)mapping.get(key);
	}

}