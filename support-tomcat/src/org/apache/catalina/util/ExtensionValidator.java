/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package org.apache.catalina.util;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;

/**
 * @author Shuyang Zhou
 */
public class ExtensionValidator {

	public static void addSystemResource(File file) throws IOException {
	}

	public static boolean validateApplication(
			WebResourceRoot webResourceRoot, Context context)
		throws IOException {

		return true;
	}

}