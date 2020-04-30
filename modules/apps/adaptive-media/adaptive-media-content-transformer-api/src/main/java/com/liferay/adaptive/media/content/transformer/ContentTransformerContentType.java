/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.content.transformer;

/**
 * Provides a marker interface to specify the content type that can be managed
 * by {@link ContentTransformer} implementations. See {@link
 * com.liferay.adaptive.media.content.transformer.constants.ContentTransformerContentTypes}
 * for examples.
 *
 * @author Alejandro Tardín
 */
public interface ContentTransformerContentType<T> {

	public String getKey();

}