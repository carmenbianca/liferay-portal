/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.connection;

import com.liferay.mule.internal.operation.BaseLiferayOperationTestCase;

import java.util.regex.Matcher;

import org.junit.Assert;
import org.junit.Test;

import org.mule.runtime.api.exception.MuleException;

/**
 * @author Matija Petanjek
 */
public class OAuth2CachedConnectionProviderTest
	extends BaseLiferayOperationTestCase {

	@Test
	public void testInvalidOAuth2CachedConnectionProvider() throws Exception {
		try {
			getPayload("invalid-oauth2-connection-flow");

			Assert.fail();
		}
		catch (MuleException muleException) {
			String message = muleException.getMessage();

			Assert.assertTrue(
				message.contains(
					"Unable to fetch access token from authorization server."));
		}
	}

	@Test
	public void testValidOAuth2CachedConnectionProvider() throws Exception {
		String payload = getPayload("valid-oauth2-connection-flow");

		Matcher matcher = productPattern.matcher(payload);

		Assert.assertTrue(matcher.matches());
	}

	@Override
	protected String getConfigFile() {
		return "test-oauth2-authentication.xml";
	}

}