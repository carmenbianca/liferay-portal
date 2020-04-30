/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.metadata;

import com.fasterxml.jackson.databind.JsonNode;

import com.liferay.mule.internal.connection.LiferayConnection;
import com.liferay.mule.internal.oas.OASConstants;
import com.liferay.mule.internal.util.JsonNodeReader;

import java.io.IOException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataKey;
import org.mule.runtime.api.metadata.MetadataKeyBuilder;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.FailureCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matija Petanjek
 */
public class MetadataKeysBuilder {

	public Set<MetadataKey> buildMetadataKeys(
			MetadataContext metadataContext, String operation)
		throws ConnectionException, MetadataResolvingException {

		Optional<LiferayConnection> liferayConnectionOptional =
			metadataContext.getConnection();

		try {
			LiferayConnection liferayConnection =
				liferayConnectionOptional.get();

			return getMetadataKeys(
				jsonNodeReader.fromHttpResponse(
					liferayConnection.getOpenAPISpec()),
				operation);
		}
		catch (IOException ioException) {
			logger.error(
				"Unable to read OpenAPI document from Liferay Portal instance",
				ioException);

			throw new MetadataResolvingException(
				ioException.getMessage(), FailureCode.NO_DYNAMIC_KEY_AVAILABLE,
				ioException);
		}
		catch (TimeoutException timeoutException) {
			logger.error(
				"Unable to establish connection to Liferay Portal instance",
				timeoutException);

			throw new MetadataResolvingException(
				timeoutException.getMessage(), FailureCode.CONNECTION_FAILURE,
				timeoutException);
		}
	}

	protected Set<MetadataKey> getMetadataKeys(
		JsonNode openAPISpecJsonNode, String operation) {

		Set<MetadataKey> metadataKeys = new HashSet<>();

		JsonNode pathsJsonNode = openAPISpecJsonNode.get(OASConstants.PATHS);

		Iterator<Map.Entry<String, JsonNode>> pathsIterator =
			pathsJsonNode.fields();

		while (pathsIterator.hasNext()) {
			Map.Entry<String, JsonNode> pathEntry = pathsIterator.next();

			JsonNode pathJsonNode = pathEntry.getValue();

			if (pathJsonNode.has(operation)) {
				String path = pathEntry.getKey();

				MetadataKeyBuilder metadataKeyBuilder =
					MetadataKeyBuilder.newKey(path);

				metadataKeys.add(metadataKeyBuilder.build());
			}
		}

		return metadataKeys;
	}

	private static final Logger logger = LoggerFactory.getLogger(
		MetadataKeysBuilder.class);

	private final JsonNodeReader jsonNodeReader = new JsonNodeReader();

}