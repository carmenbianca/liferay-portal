/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

/**
 * @author Hugo Huijser
 */
public class JavaFinallyStatement extends BaseJavaTerm {

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		return indent + "finally {";
	}

}