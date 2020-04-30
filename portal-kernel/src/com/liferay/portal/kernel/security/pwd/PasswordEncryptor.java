/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.pwd;

import com.liferay.portal.kernel.exception.PwdEncryptorException;

/**
 * @author Tomas Polesovsky
 */
public interface PasswordEncryptor {

	public String encrypt(String plainTextPassword, String encryptedPassword)
		throws PwdEncryptorException;

	public String encrypt(
			String algorithm, String plainTextPassword,
			String encryptedPassword)
		throws PwdEncryptorException;

	public String getDefaultPasswordAlgorithmType();

	public String[] getSupportedAlgorithmTypes();

}