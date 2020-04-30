/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.security.io;

import java.io.InputStream;

/**
 * @author Adolfo Pérez
 */
public interface InputStreamSanitizer {

	public InputStream sanitize(InputStream inputStream);

}