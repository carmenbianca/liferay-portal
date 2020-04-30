/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.util;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @author Adolfo Pérez
 */
public class InputStreamUtil {

	public static BufferedInputStream toBufferedInputStream(
		InputStream inputStream) {

		if (inputStream instanceof BufferedInputStream) {
			return (BufferedInputStream)inputStream;
		}

		return new BufferedInputStream(inputStream);
	}

}