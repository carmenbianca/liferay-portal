/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.netty.fileserver;

import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.zip.Deflater;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class CompressionLevelTest {

	@ClassRule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Test
	public void testLevels() {
		Assert.assertEquals(
			Deflater.BEST_COMPRESSION,
			CompressionLevel.BEST_COMPRESSION.getLevel());
		Assert.assertEquals(
			Deflater.BEST_SPEED, CompressionLevel.BEST_SPEED.getLevel());
		Assert.assertEquals(
			Deflater.DEFAULT_COMPRESSION,
			CompressionLevel.DEFAULT_COMPRESSION.getLevel());
		Assert.assertEquals(2, CompressionLevel.LEVEL_2.getLevel());
		Assert.assertEquals(3, CompressionLevel.LEVEL_3.getLevel());
		Assert.assertEquals(4, CompressionLevel.LEVEL_4.getLevel());
		Assert.assertEquals(5, CompressionLevel.LEVEL_5.getLevel());
		Assert.assertEquals(6, CompressionLevel.LEVEL_6.getLevel());
		Assert.assertEquals(7, CompressionLevel.LEVEL_7.getLevel());
		Assert.assertEquals(8, CompressionLevel.LEVEL_8.getLevel());
		Assert.assertEquals(
			Deflater.NO_COMPRESSION,
			CompressionLevel.NO_COMPRESSION.getLevel());
	}

	@Test
	public void testLookupTable() {
		Map<Integer, CompressionLevel> compressionLevels =
			ReflectionTestUtil.getFieldValue(
				CompressionLevel.class, "_compressionLevels");

		Assert.assertEquals(
			EnumSet.allOf(CompressionLevel.class),
			new HashSet<CompressionLevel>(compressionLevels.values()));

		for (Map.Entry<Integer, CompressionLevel> entry :
				compressionLevels.entrySet()) {

			CompressionLevel compressionLevel = entry.getValue();

			Assert.assertEquals(
				entry.getKey(), Integer.valueOf(compressionLevel.getLevel()));
		}

		Assert.assertSame(
			CompressionLevel.BEST_COMPRESSION,
			CompressionLevel.getCompressionLevel(Deflater.BEST_COMPRESSION));

		try {
			CompressionLevel.getCompressionLevel(10);

			Assert.fail();
		}
		catch (IllegalArgumentException illegalArgumentException) {
			Assert.assertEquals(
				"Compression level 10 is not within the range of -1 and 9",
				illegalArgumentException.getMessage());
		}
	}

}