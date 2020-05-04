/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.configuration;

import com.liferay.adaptive.media.image.processor.AMImageAttribute;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.MapUtil;

import java.util.Collections;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adolfo Pérez
 */
public class AMImageAttributeMappingTest {

	@Test
	public void testCreateFromEmptyMap() {
		AMImageAttributeMapping amImageAttributeMapping =
			AMImageAttributeMapping.fromProperties(Collections.emptyMap());

		Optional<Integer> heightOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_HEIGHT);

		Assert.assertFalse(heightOptional.isPresent());

		Optional<Integer> widthOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_WIDTH);

		Assert.assertFalse(widthOptional.isPresent());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWhenCreatingFromNullMap() {
		AMImageAttributeMapping.fromProperties(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWhenGettingValueOfNullAttribute() {
		AMImageAttributeMapping amImageAttributeMapping =
			AMImageAttributeMapping.fromProperties(
				MapUtil.fromArray(
					AMImageAttribute.AM_IMAGE_ATTRIBUTE_HEIGHT.getName(), "100",
					AMImageAttribute.AM_IMAGE_ATTRIBUTE_WIDTH.getName(),
					"200"));

		amImageAttributeMapping.getValueOptional(null);
	}

	@Test
	public void testIgnoreUnknownAttributes() {
		AMImageAttributeMapping amImageAttributeMapping =
			AMImageAttributeMapping.fromProperties(
				MapUtil.fromArray("foo", RandomTestUtil.randomString()));

		Optional<Integer> heightOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_HEIGHT);

		Assert.assertFalse(heightOptional.isPresent());

		Optional<Integer> widthOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_WIDTH);

		Assert.assertFalse(widthOptional.isPresent());
	}

	@Test
	public void testValidAttributes() {
		AMImageAttributeMapping amImageAttributeMapping =
			AMImageAttributeMapping.fromProperties(
				MapUtil.fromArray(
					AMImageAttribute.AM_IMAGE_ATTRIBUTE_HEIGHT.getName(), "100",
					AMImageAttribute.AM_IMAGE_ATTRIBUTE_WIDTH.getName(),
					"200"));

		Optional<Integer> heightOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_HEIGHT);

		Assert.assertEquals(Integer.valueOf(100), heightOptional.get());

		Optional<Integer> widthOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_WIDTH);

		Assert.assertEquals(Integer.valueOf(200), widthOptional.get());
	}

	@Test
	public void testValidSingleAttribute() {
		AMImageAttributeMapping amImageAttributeMapping =
			AMImageAttributeMapping.fromProperties(
				MapUtil.fromArray(
					AMImageAttribute.AM_IMAGE_ATTRIBUTE_HEIGHT.getName(),
					"100"));

		Optional<Integer> heightOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_HEIGHT);

		Assert.assertEquals(Integer.valueOf(100), heightOptional.get());

		Optional<Integer> widthOptional =
			amImageAttributeMapping.getValueOptional(
				AMImageAttribute.AM_IMAGE_ATTRIBUTE_WIDTH);

		Assert.assertFalse(widthOptional.isPresent());
	}

}