/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.pwd;

import com.liferay.portal.kernel.security.pwd.PasswordEncryptor;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;

/**
 * @author Michael C. Han
 * @author Tomas Polesovsky
 */
public class NullPasswordEncryptor
	extends BasePasswordEncryptor implements PasswordEncryptor {

	@Override
	public String encrypt(
		String algorithm, String plainTextPassword, String encryptedPassword) {

		return plainTextPassword;
	}

	@Override
	public String[] getSupportedAlgorithmTypes() {
		return new String[] {PasswordEncryptorUtil.TYPE_NONE};
	}

}