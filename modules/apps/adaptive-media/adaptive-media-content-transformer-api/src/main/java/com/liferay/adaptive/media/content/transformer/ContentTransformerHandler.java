/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.content.transformer;

/**
 * @author Lance Ji
 */
public interface ContentTransformerHandler {

	public <T> T transform(
		ContentTransformerContentType<T> contentTransformerContentType,
		T originalContent);

}