/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.pwd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.model.impl.PasswordPolicyImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Mika Koivisto
 */
public class PasswordPolicyToolkitTest {

	@Before
	public void setUp() throws Exception {
		_passwordPolicyToolkit = new PasswordPolicyToolkit();

		_passwordPolicy = new PasswordPolicyImpl();

		_passwordPolicy.setChangeable(true);
		_passwordPolicy.setCheckSyntax(true);
		_passwordPolicy.setAllowDictionaryWords(true);
		_passwordPolicy.setMinAlphanumeric(5);
		_passwordPolicy.setMinLength(8);
		_passwordPolicy.setMinLowerCase(2);
		_passwordPolicy.setMinNumbers(1);
		_passwordPolicy.setMinSymbols(1);
		_passwordPolicy.setMinUpperCase(2);
		_passwordPolicy.setRegex(".{5,}");
	}

	@Test
	public void testGeneratePassword() throws PortalException {
		String password = _passwordPolicyToolkit.generate(_passwordPolicy);

		_passwordPolicyToolkit.validate(password, password, _passwordPolicy);
	}

	@Test
	public void testValidateLength() {
		Assert.assertEquals(false, validate("xH9fxM@"));
	}

	@Test
	public void testValidateMinAlphanumeric() {
		Assert.assertEquals(false, validate("xH9f.,@-"));
	}

	@Test
	public void testValidateMinLowerChars() {
		Assert.assertEquals(false, validate("xHFXM@W"));
	}

	@Test
	public void testValidateMinNumbers() {
		Assert.assertEquals(false, validate("xHafxMkw"));
	}

	@Test
	public void testValidateMinSpecial() {
		Assert.assertEquals(false, validate("xH9fxMkw"));
	}

	@Test
	public void testValidateMinUpperChars() {
		Assert.assertEquals(false, validate("xh9fxM@w"));
	}

	@Test
	public void testValidateRegex() {
		Assert.assertEquals(false, validate("xH9fxM@"));
	}

	@Test
	public void testValidateValid() {
		Assert.assertEquals(true, validate("xH9fxM@w"));
	}

	@Test
	public void testValidateValidUpperCase() {
		Assert.assertEquals(true, validate("xO9fxlM@w"));
	}

	protected boolean validate(String password) {
		try {
			_passwordPolicyToolkit.validate(
				password, password, _passwordPolicy);
		}
		catch (Exception exception) {
			return false;
		}

		return true;
	}

	private PasswordPolicy _passwordPolicy;
	private PasswordPolicyToolkit _passwordPolicyToolkit;

}