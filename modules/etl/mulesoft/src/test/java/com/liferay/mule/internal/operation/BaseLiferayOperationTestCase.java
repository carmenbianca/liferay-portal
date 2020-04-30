/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.operation;

import java.util.regex.Pattern;

import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.event.Event;
import org.mule.runtime.api.message.Message;
import org.mule.runtime.api.metadata.TypedValue;

/**
 * @author Matija Petanjek
 */
public abstract class BaseLiferayOperationTestCase
	extends MuleArtifactFunctionalTestCase {

	protected String getPayload(String flowName) throws Exception {
		Event event = runFlow(flowName);

		Message message = event.getMessage();

		TypedValue<String> payloadTypedValue = message.getPayload();

		return payloadTypedValue.getValue();
	}

	protected static final Pattern productPattern = Pattern.compile(
		"[\\s\\S]+\"active\"[\\s\\S]+\"catalogId\"[\\s\\S]+" +
			"\"name\"[\\s\\S]+\"productType\"[\\s\\S]+");

}