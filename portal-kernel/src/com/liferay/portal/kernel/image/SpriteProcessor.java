/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.image;

import java.io.IOException;

import java.net.URL;

import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 */
public interface SpriteProcessor {

	public static final String PATH = "/sprite";

	public Properties generate(
			ServletContext servletContext, List<URL> imageURLs,
			String spriteRootDirName, String spriteFileName,
			String spritePropertiesFileName, String rootPath, int maxHeight,
			int maxWidth, int maxSize)
		throws IOException;

}