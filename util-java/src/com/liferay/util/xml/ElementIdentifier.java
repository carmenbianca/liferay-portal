/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.xml;

/**
 * @author Jorge Ferrer
 */
public class ElementIdentifier {

	public ElementIdentifier(String elementName, String identifierName) {
		_elementName = elementName;
		_identifierName = identifierName;
	}

	public String getElementName() {
		return _elementName;
	}

	public String getIdentifierName() {
		return _identifierName;
	}

	private final String _elementName;
	private final String _identifierName;

}