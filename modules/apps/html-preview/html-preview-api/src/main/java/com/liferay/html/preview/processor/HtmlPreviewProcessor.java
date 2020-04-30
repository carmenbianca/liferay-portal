/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.html.preview.processor;

import java.io.File;

/**
 * @author Pavel Savinov
 */
public interface HtmlPreviewProcessor {

	public static final int WIDTH_DEFAULT = 1024;

	public File generateContentHtmlPreview(String content);

	public File generateContentHtmlPreview(String content, int width);

	public File generateURLHtmlPreview(String url);

	public File generateURLHtmlPreview(String url, int width);

	public String getMimeType();

}