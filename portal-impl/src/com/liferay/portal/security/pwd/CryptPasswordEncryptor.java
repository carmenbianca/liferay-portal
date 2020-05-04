/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.pwd;

import com.liferay.portal.kernel.exception.PwdEncryptorException;
import com.liferay.portal.kernel.security.SecureRandom;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptor;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Digester;
import com.liferay.portal.kernel.util.Validator;

import java.io.UnsupportedEncodingException;

import java.util.Random;

import org.vps.crypt.Crypt;

/**
 * @author Michael C. Han
 * @author Tomas Polesovsky
 */
public class CryptPasswordEncryptor
	extends BasePasswordEncryptor implements PasswordEncryptor {

	@Override
	public String encrypt(
			String algorithm, String plainTextPassword,
			String encryptedPassword)
		throws PwdEncryptorException {

		byte[] saltBytes = getSalt(encryptedPassword);

		try {
			return Crypt.crypt(
				saltBytes, plainTextPassword.getBytes(Digester.ENCODING));
		}
		catch (UnsupportedEncodingException unsupportedEncodingException) {
			throw new PwdEncryptorException(
				unsupportedEncodingException.getMessage(),
				unsupportedEncodingException);
		}
	}

	@Override
	public String[] getSupportedAlgorithmTypes() {
		return new String[] {
			PasswordEncryptorUtil.TYPE_UFC_CRYPT,
			PasswordEncryptorUtil.TYPE_UFC_CRYPT
		};
	}

	protected byte[] getSalt(String encryptedPassword)
		throws PwdEncryptorException {

		byte[] saltBytes = null;

		try {
			if (Validator.isNull(encryptedPassword)) {
				Random random = new SecureRandom();

				int x = random.nextInt(Integer.MAX_VALUE) % _SALT.length;
				int y = random.nextInt(Integer.MAX_VALUE) % _SALT.length;

				String salt = _SALT[x].concat(_SALT[y]);

				saltBytes = salt.getBytes(Digester.ENCODING);
			}
			else {
				String salt = encryptedPassword.substring(0, 2);

				saltBytes = salt.getBytes(Digester.ENCODING);
			}
		}
		catch (UnsupportedEncodingException unsupportedEncodingException) {
			throw new PwdEncryptorException(
				"Unable to extract salt from encrypted password " +
					unsupportedEncodingException.getMessage(),
				unsupportedEncodingException);
		}

		return saltBytes;
	}

	private static final String[] _SALT = ArrayUtil.toStringArray(
		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789./".
			toCharArray());

}