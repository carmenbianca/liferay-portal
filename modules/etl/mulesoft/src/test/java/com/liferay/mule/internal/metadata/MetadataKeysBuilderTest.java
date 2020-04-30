/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.metadata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.mule.internal.oas.OASConstants;

import java.io.IOException;
import java.io.InputStream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mule.runtime.api.metadata.MetadataKey;

/**
 * @author Matija Petanjek
 */
public class MetadataKeysBuilderTest {

	@Before
	public void setUp() throws IOException {
		Class<?> clazz = getClass();

		ClassLoader classLoader = clazz.getClassLoader();

		InputStream inputStream = classLoader.getResourceAsStream(
			"com/liferay/mule/internal/metadata/oas-fragment-metadata-keys." +
				"json");

		ObjectMapper objectMapper = new ObjectMapper();

		openAPISpecJsonNode = objectMapper.readTree(inputStream);
	}

	@Test
	public void testBuildDELETEEndpointMetadataKeys() {
		MetadataKeysBuilder metadataKeysBuilder = new MetadataKeysBuilder();

		Set<String> metadataKeyIds = toMetadataKeyIdSet(
			metadataKeysBuilder.getMetadataKeys(
				openAPISpecJsonNode, OASConstants.OPERATION_DELETE));

		Assert.assertTrue(
			metadataKeyIds.contains("/endpoint/with/delete/and/get/operation"));
	}

	@Test
	public void testBuildEmptyMetadataKeys() {
		MetadataKeysBuilder metadataKeysBuilder = new MetadataKeysBuilder();

		Set<MetadataKey> metadataKeys = metadataKeysBuilder.getMetadataKeys(
			openAPISpecJsonNode, OPERATION_HEAD);

		Assert.assertTrue(metadataKeys.isEmpty());
	}

	@Test
	public void testBuildGETEndpointMetadataKeys() {
		MetadataKeysBuilder metadataKeysBuilder = new MetadataKeysBuilder();

		Set<String> metadataKeyIds = toMetadataKeyIdSet(
			metadataKeysBuilder.getMetadataKeys(
				openAPISpecJsonNode, OASConstants.OPERATION_GET));

		Assert.assertTrue(
			metadataKeyIds.contains("/endpoint/with/delete/and/get/operation"));
		Assert.assertTrue(
			metadataKeyIds.contains("/endpoint/with/get/and/patch/operation"));
		Assert.assertTrue(
			metadataKeyIds.contains("/endpoint/with/get/and/post/operation"));
	}

	@Test
	public void testBuildPATCHEndpointMetadataKeys() {
		MetadataKeysBuilder metadataKeysBuilder = new MetadataKeysBuilder();

		Set<String> metadataKeyIds = toMetadataKeyIdSet(
			metadataKeysBuilder.getMetadataKeys(
				openAPISpecJsonNode, OASConstants.OPERATION_PATCH));

		Assert.assertTrue(
			metadataKeyIds.contains("/endpoint/with/get/and/patch/operation"));
	}

	@Test
	public void testBuildPOSTEndpointMetadataKeys() {
		MetadataKeysBuilder metadataKeysBuilder = new MetadataKeysBuilder();

		Set<String> metadataKeyIds = toMetadataKeyIdSet(
			metadataKeysBuilder.getMetadataKeys(
				openAPISpecJsonNode, OASConstants.OPERATION_POST));

		Assert.assertTrue(
			metadataKeyIds.contains("/endpoint/with/get/and/post/operation"));
	}

	private Set<String> toMetadataKeyIdSet(Set<MetadataKey> metadataKeys) {
		Stream<MetadataKey> stream = metadataKeys.stream();

		return stream.map(
			MetadataKey::getId
		).collect(
			Collectors.toSet()
		);
	}

	private static final String OPERATION_HEAD = "head";

	private JsonNode openAPISpecJsonNode;

}