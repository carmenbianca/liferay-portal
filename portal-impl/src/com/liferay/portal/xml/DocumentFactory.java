/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xml;

/**
 * @author Jorge Díaz
 */
public class DocumentFactory extends org.dom4j.DocumentFactory {

	public static DocumentFactory getInstance() {
		return _documentFactory;
	}

	@Override
	protected QNameCache createQNameCache() {
		return new QNameCache(this);
	}

	private static final DocumentFactory _documentFactory =
		new DocumentFactory();

}