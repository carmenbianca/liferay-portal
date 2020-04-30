/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.javadoc;

/**
 * @author Igor Spasic
 */
public class JavadocClass extends BaseJavadoc {

	public JavadocClass(
		String servletContextName, String comment, Class<?> clazz,
		String[] authors) {

		super(servletContextName, comment);

		_clazz = clazz;
		_authors = authors;
	}

	public String[] getAuthors() {
		return _authors;
	}

	public Class<?> getClazz() {
		return _clazz;
	}

	private final String[] _authors;
	private final Class<?> _clazz;

}