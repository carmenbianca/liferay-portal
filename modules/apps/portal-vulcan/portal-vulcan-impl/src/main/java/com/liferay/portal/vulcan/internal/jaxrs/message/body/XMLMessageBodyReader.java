/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.message.body;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * @author Ivica Cardic
 */
@Consumes(MediaType.APPLICATION_XML)
@Provider
public class XMLMessageBodyReader extends BaseMessageBodyReader {

	public XMLMessageBodyReader() {
		super(XmlMapper.class, MediaType.APPLICATION_XML_TYPE);
	}

}