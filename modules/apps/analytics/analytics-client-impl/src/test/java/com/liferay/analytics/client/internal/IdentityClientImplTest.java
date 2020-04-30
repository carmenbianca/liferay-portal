/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client.internal;

import com.liferay.analytics.model.IdentityContextMessage;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Eduardo García
 */
@Ignore
public class IdentityClientImplTest {

	@Test
	public void testGetUUID() throws Exception {
		IdentityContextMessage.Builder identityContextMessageBuilder =
			IdentityContextMessage.builder("ApplicationKey");

		identityContextMessageBuilder.dataSourceIdentifier("Liferay");
		identityContextMessageBuilder.dataSourceIndividualIdentifier("12345");
		identityContextMessageBuilder.domain("liferay.com");
		identityContextMessageBuilder.language("en-US");
		identityContextMessageBuilder.protocolVersion("1.0");

		identityContextMessageBuilder.identityFieldsProperty(
			"email", "julio.camarero@liferay.com");
		identityContextMessageBuilder.identityFieldsProperty(
			"name", "Julio Camarero");

		String response = _identityClientImpl.getUserId(
			identityContextMessageBuilder.build());

		Assert.assertNotNull(response);
	}

	private final IdentityClientImpl _identityClientImpl =
		new IdentityClientImpl();

}