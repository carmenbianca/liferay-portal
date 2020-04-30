/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.parsers.bbcode;

/**
 * @author Iliyan Peychev
 * @author Miguel Pastor
 */
public interface BBCodeTranslator {

	public String[] getEmoticonDescriptions();

	public String[] getEmoticonFiles();

	public String[][] getEmoticons();

	public String[] getEmoticonSymbols();

	public String getHTML(String bbcode);

	public String parse(String message);

}