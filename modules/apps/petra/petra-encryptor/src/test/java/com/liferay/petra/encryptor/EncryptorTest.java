/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.encryptor;

import com.liferay.portal.kernel.test.util.PropsTestUtil;
import com.liferay.portal.kernel.util.PropsKeys;

import java.security.Key;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mika Koivisto
 * @see    com.liferay.util.EncryptorTest
 */
public class EncryptorTest {

	@Test
	public void testKeySerialization() throws Exception {
		Map<String, Object> properties = new HashMap<>();

		properties.put(PropsKeys.COMPANY_ENCRYPTION_ALGORITHM, "AES");
		properties.put(PropsKeys.COMPANY_ENCRYPTION_KEY_SIZE, "128");

		PropsTestUtil.setProps(properties);

		Key key = Encryptor.generateKey();

		String encryptedString = Encryptor.encrypt(key, "Hello World!");

		String serializedKey = Encryptor.serializeKey(key);

		key = Encryptor.deserializeKey(serializedKey);

		Assert.assertEquals(
			"Hello World!", Encryptor.decrypt(key, encryptedString));
	}

}