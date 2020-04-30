/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.validator;

import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * Validates image size for Adaptive Media.
 *
 * @author Sergio González
 */
public interface AMImageValidator {

	/**
	 * Returns <code>true</code> if the provided file version supports image
	 * processing. Adaptive Media works with some media types where the content
	 * doesn't need to be processed or doesn't support processing at all (e.g.
	 * SVG).
	 *
	 * @return <code>true</code> if the file version supports image processing.
	 * @review
	 */
	public default boolean isProcessingSupported(FileVersion fileVersion) {
		return isValid(fileVersion);
	}

	/**
	 * Returns <code>true</code> if the provided file version is valid for
	 * Adaptive Media.
	 *
	 * @return <code>true</code> if the file version is valid for Adaptive Media
	 */
	public boolean isValid(FileVersion fileVersion);

}