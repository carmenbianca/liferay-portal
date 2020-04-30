/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.util;

import com.liferay.portal.kernel.util.ObjectValuePair;

import java.io.InputStream;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Eduardo Pérez
 */
@RunWith(PowerMockRunner.class)
public class MBMailMessageTest {

	@Test
	public void testAddBytes() throws Exception {
		MBMailMessage mbMailMessage = new MBMailMessage();

		mbMailMessage.addBytes("=?UTF-8?Q?T=C3=ADlde.txt?=", new byte[0]);

		List<ObjectValuePair<String, InputStream>> inputStreamOVPs =
			mbMailMessage.getInputStreamOVPs();

		ObjectValuePair<String, InputStream> inputStreamOVP =
			inputStreamOVPs.get(0);

		Assert.assertEquals("T\u00EDlde.txt", inputStreamOVP.getKey());
	}

}