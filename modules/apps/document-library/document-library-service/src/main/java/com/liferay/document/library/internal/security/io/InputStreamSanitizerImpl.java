/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.security.io;

import com.liferay.document.library.internal.util.InputStreamUtil;
import com.liferay.document.library.security.io.InputStreamSanitizer;

import java.io.InputStream;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(service = InputStreamSanitizer.class)
public class InputStreamSanitizerImpl implements InputStreamSanitizer {

	@Override
	public InputStream sanitize(InputStream inputStream) {
		return new SafePNGInputStream(
			InputStreamUtil.toBufferedInputStream(inputStream));
	}

}