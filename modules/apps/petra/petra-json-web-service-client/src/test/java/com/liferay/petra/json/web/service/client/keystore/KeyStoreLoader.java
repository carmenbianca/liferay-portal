/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client.keystore;

import java.io.IOException;
import java.io.InputStream;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author Igor Beslic
 */
public class KeyStoreLoader {

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getKeyStore(String, String)}
	 */
	@Deprecated
	public KeyStore getKeystore(
			String keyStoreFileName, String keyStorePassword)
		throws CertificateException, IOException, KeyStoreException,
			   NoSuchAlgorithmException {

		return getKeyStore(keyStoreFileName, keyStorePassword);
	}

	public KeyStore getKeyStore(
			String keyStoreFileName, String keyStorePassword)
		throws CertificateException, IOException, KeyStoreException,
			   NoSuchAlgorithmException {

		Class<?> clazz = KeyStoreLoader.class;

		try (InputStream inputStream = clazz.getResourceAsStream(
				"dependencies/" + keyStoreFileName)) {

			KeyStore keyStore = KeyStore.getInstance("jks");

			keyStore.load(inputStream, keyStorePassword.toCharArray());

			return keyStore;
		}
	}

}