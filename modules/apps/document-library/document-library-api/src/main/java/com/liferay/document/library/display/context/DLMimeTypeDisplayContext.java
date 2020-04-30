/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.display.context;

/**
 * @author Roberto Díaz
 */
public interface DLMimeTypeDisplayContext {

	public String getCssClassFileMimeType(String mimeType);

	public default String getIconFileMimeType(String mimeType) {
		return "document-default";
	}

}