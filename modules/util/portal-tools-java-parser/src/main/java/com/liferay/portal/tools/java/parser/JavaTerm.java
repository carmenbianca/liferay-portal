/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

/**
 * @author Hugo Huijser
 */
public interface JavaTerm {

	public Position getEndPosition();

	public Position getStartPosition();

	public String getSuffix();

	public void setEndPosition(Position endPosition);

	public void setStartPosition(Position startPosition);

	public void setSuffix(String suffix);

	public String toString(String indent, String prefix, int maxLineLength);

	public String toString(
		String indent, String prefix, String suffix, int maxLineLength);

	public String toString(
		String indent, String prefix, String suffix, int maxLineLength,
		boolean forceLineBreak);

}