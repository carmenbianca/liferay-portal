/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kevin Yen
 */
public class JenkinsStopBuildUtilTest {

	@Test
	public void testEncodeAuthorizationFields() {
		String encodedString = JenkinsStopBuildUtil.encodeAuthorizationFields(
			"test", "test");

		Assert.assertEquals("dGVzdDp0ZXN0", encodedString);
	}

}