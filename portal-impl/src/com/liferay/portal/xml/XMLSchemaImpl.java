/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.XMLSchema;
import com.liferay.portal.util.EntityResolver;

import org.xml.sax.InputSource;

/**
 * @author Marcellus Tavares
 */
public class XMLSchemaImpl implements XMLSchema {

	@Override
	public String getPublicId() {
		return _publicId;
	}

	@Override
	public String getSchemaLanguage() {
		return _schemaLanguage;
	}

	@Override
	public InputSource getSchemaSource() {
		EntityResolver entityResolver = new EntityResolver();

		return entityResolver.resolveEntity(_publicId, _systemId);
	}

	@Override
	public String getSystemId() {
		return _systemId;
	}

	public void setPublicId(String publicId) {
		_publicId = publicId;
	}

	public void setSchemaLanguage(String schemaLanguage) {
		_schemaLanguage = schemaLanguage;
	}

	public void setSystemId(String systemId) {
		_systemId = systemId;
	}

	private String _publicId;
	private String _schemaLanguage;
	private String _systemId;

}