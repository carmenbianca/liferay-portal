/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.workspace.internal.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Gregory Amerson
 */
public class VersionUtilTest {

	@Test
	public void testIsDXPVersion() throws Exception {
		Assert.assertFalse("x", VersionUtil.isDXPVersion("x"));
		Assert.assertFalse("7.1.0", VersionUtil.isDXPVersion("7.1.0"));
		Assert.assertFalse("7.1.1", VersionUtil.isDXPVersion("7.1.1"));
		Assert.assertTrue("7.0.10", VersionUtil.isDXPVersion("7.0.10"));
		Assert.assertTrue("7.0.10.1", VersionUtil.isDXPVersion("7.0.10.1"));
		Assert.assertTrue(
			"7.0.10.fp21", VersionUtil.isDXPVersion("7.0.10.fp21"));
		Assert.assertTrue("7.1.10", VersionUtil.isDXPVersion("7.1.10"));
		Assert.assertTrue("7.1.10.1", VersionUtil.isDXPVersion("7.1.10.1"));
		Assert.assertTrue(
			"7.1.10.fp21", VersionUtil.isDXPVersion("7.1.10.fp21"));
		Assert.assertTrue(
			"7.1.10.fp1-1", VersionUtil.isDXPVersion("7.1.10.fp1-1"));
		Assert.assertTrue(
			"7.1.10.fp123-456", VersionUtil.isDXPVersion("7.1.10.fp123-456"));
	}

	@Test
	public void testNormalizeTargetPlatformVersion() throws Exception {
		Assert.assertEquals(
			"7.0.0", VersionUtil.normalizeTargetPlatformVersion("7.0.0"));
		Assert.assertEquals(
			"7.0.0", VersionUtil.normalizeTargetPlatformVersion("7.0-GA1"));
		Assert.assertEquals(
			"7.0.0", VersionUtil.normalizeTargetPlatformVersion("7.0-ga1"));
		Assert.assertEquals(
			"7.0.6", VersionUtil.normalizeTargetPlatformVersion("7.0-GA7"));
		Assert.assertEquals(
			"7.0.6", VersionUtil.normalizeTargetPlatformVersion("7.0-ga7"));
		Assert.assertEquals(
			"7.0.10.1", VersionUtil.normalizeTargetPlatformVersion("7.0.10.1"));
		Assert.assertEquals(
			"7.0.10.fp1",
			VersionUtil.normalizeTargetPlatformVersion("7.0.10.fp1"));
	}

}