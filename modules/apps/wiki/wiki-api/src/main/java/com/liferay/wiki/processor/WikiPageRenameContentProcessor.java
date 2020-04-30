/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.processor;

/**
 * @author Roberto Díaz
 * @author Sergio González
 */
public interface WikiPageRenameContentProcessor {

	public String processContent(
		long nodeId, String originalTitle, String newTitle,
		String originalContent);

}