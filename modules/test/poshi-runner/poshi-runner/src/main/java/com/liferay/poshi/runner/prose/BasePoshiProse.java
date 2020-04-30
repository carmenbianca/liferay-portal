/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.prose;

import java.util.regex.Pattern;

import org.dom4j.Element;

/**
 * @author Yi-Chen Tsai
 */
public abstract class BasePoshiProse {

	public String filterCommentLines(String content) {
		return content.replaceAll(commentLinePattern.pattern(), "");
	}

	public abstract Element toElement();

	protected final Pattern commentLinePattern = Pattern.compile("\\s*#.*");
	protected final Pattern tagPattern = Pattern.compile(
		"\\@\\s*(?<tagName>.*?)\\s*\\=\\s*\"(?<tagValue>.*)\"");

}