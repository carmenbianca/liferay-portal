/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.parser;

/**
 * @author Hugo Huijser
 */
public class JavaConstructor extends BaseJavaTerm {

	public JavaConstructor(
		String name, String content, String accessModifier, int lineNumber,
		boolean isAbstract, boolean isStatic) {

		super(name, content, accessModifier, lineNumber, isAbstract, isStatic);
	}

	@Override
	public JavaSignature getSignature() {
		if (_signature == null) {
			_signature = JavaSignatureParser.parseJavaSignature(
				getContent(), getAccessModifier(), false);
		}

		return _signature;
	}

	private JavaSignature _signature;

}