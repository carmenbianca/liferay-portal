/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.pwd;

import com.liferay.portal.kernel.security.pwd.PasswordEncryptor;
import com.liferay.portal.kernel.util.DigesterUtil;

/**
 * @author Michael C. Han
 * @author Tomas Polesovsky
 */
public class DefaultPasswordEncryptor
	extends BasePasswordEncryptor implements PasswordEncryptor {

	@Override
	public String encrypt(
		String algorithm, String plainTextPassword, String encryptedPassword) {

		return DigesterUtil.digest(algorithm, plainTextPassword);
	}

	@Override
	public String[] getSupportedAlgorithmTypes() {
		return new String[0];
	}

}