/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.content.transformer;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Transforms the original content to include Adaptive Media. This logic is
 * invoked before the content is rendered.
 *
 * <p>
 * Implementations of this interface must specify the {@link
 * ContentTransformerContentType} that they can manage and the implementation of
 * the transform function.
 * </p>
 *
 * @author Alejandro Tardín
 */
public interface ContentTransformer<T> {

	public ContentTransformerContentType<T> getContentTransformerContentType();

	public T transform(T content) throws PortalException;

}