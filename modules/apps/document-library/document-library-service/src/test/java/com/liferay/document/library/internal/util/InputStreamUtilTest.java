/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adolfo Pérez
 */
public class InputStreamUtilTest {

	@Test
	public void testBufferedInputStreamIsNotWrapped() {
		InputStream inputStream = new BufferedInputStream(
			new ByteArrayInputStream(new byte[0]));

		Assert.assertSame(
			inputStream, InputStreamUtil.toBufferedInputStream(inputStream));
	}

	@Test
	public void testUnbufferedInputStreamIsWrapped() {
		InputStream inputStream = new ByteArrayInputStream(new byte[0]);

		Assert.assertNotSame(
			inputStream, InputStreamUtil.toBufferedInputStream(inputStream));
	}

}