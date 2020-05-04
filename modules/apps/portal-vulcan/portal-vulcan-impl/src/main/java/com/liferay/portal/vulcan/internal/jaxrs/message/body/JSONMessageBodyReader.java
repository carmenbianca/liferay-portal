/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.message.body;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * @author Javier Gamarra
 * @author Ivica Cardic
 */
@Consumes(MediaType.APPLICATION_JSON)
@Provider
public class JSONMessageBodyReader extends BaseMessageBodyReader {

	public JSONMessageBodyReader() {
		super(ObjectMapper.class, MediaType.APPLICATION_JSON_TYPE);
	}

}