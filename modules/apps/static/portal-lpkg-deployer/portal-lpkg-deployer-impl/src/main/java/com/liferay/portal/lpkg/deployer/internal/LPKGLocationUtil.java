/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer.internal;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;

import java.net.URI;

import org.osgi.framework.Bundle;

/**
 * @author Matthew Tambara
 */
public class LPKGLocationUtil {

	public static String generateInnerBundleLocation(
		Bundle lpkgBundle, String path) {

		String location = path.concat("?lpkgPath=");

		return location.concat(lpkgBundle.getLocation());
	}

	public static String getLPKGLocation(File lpkgFile) {
		URI uri = lpkgFile.toURI();

		String uriString = uri.toString();

		return StringUtil.replace(
			uriString, CharPool.BACK_SLASH, CharPool.FORWARD_SLASH);
	}

}