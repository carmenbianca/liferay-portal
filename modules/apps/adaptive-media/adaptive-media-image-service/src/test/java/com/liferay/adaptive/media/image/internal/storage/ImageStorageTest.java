/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.storage;

import com.liferay.portal.kernel.test.util.RandomTestUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adolfo Pérez
 */
public class ImageStorageTest {

	@Test
	public void testGetConfigurationEntryPath() {
		String configurationUuid = RandomTestUtil.randomString();

		String configurationEntryPath = _imageStorage.getConfigurationEntryPath(
			configurationUuid);

		Assert.assertEquals(
			"adaptive/" + configurationUuid, configurationEntryPath);
	}

	private final ImageStorage _imageStorage = new ImageStorage();

}