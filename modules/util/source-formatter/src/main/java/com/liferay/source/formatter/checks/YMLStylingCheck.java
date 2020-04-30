/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Alan Huang
 */
public class YMLStylingCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		content = content.replaceAll(
			"(\\A|\n)( *.+:) {2,}(.+)(\\Z|\n)", "$1$2 $3$4");

		content = content.replaceAll(
			"(\\A|\n)( *)(description:) (?!\\|-)(.+)(\\Z|\n)",
			"$1$2$3\n    $2$4$5");

		content = content.replaceAll(
			"(\\A|\n)( *#)@? ?(review)(\\Z|\n)", "$1$2 @$3$4");

		content = content.replaceAll(
			"(\\A|\n)(( *)|(.+: ))'([^']*)'(\\Z|\n)", "$1$2\"$5\"$6");

		content = content.replaceAll(
			"(\\A|\n)( *)'([^']+)'(:.*)(\\Z|\n)", "$1$2\"$3\"$4$5");

		return content;
	}

}