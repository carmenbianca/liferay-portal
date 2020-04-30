/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.html.preview.processor;

/**
 * @author Lance Ji
 */
public interface HtmlPreviewProcessorTracker {

	public HtmlPreviewProcessor getHtmlPreviewProcessor(String mimeType);

}