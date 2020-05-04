/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.message.body;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * @author Alejandro Hernández
 * @author Ivica Cardic
 */
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class JSONMessageBodyWriter extends BaseMessageBodyWriter {

	public JSONMessageBodyWriter() {
		super(ObjectMapper.class, MediaType.APPLICATION_JSON_TYPE);
	}

}