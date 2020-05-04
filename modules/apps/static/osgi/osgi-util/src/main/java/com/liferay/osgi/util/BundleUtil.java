/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.util;

import java.net.URL;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.osgi.framework.Bundle;

/**
 * @author Carlos Sierra Andrés
 */
public class BundleUtil {

	public static URL getResourceInBundleOrFragments(
		Bundle bundle, String name) {

		String dirName = "/";
		String fileName = name;

		int index = name.lastIndexOf('/');

		if (index > 0) {
			dirName = name.substring(0, index);
			fileName = name.substring(index + 1);
		}
		else if (index == 0) {
			fileName = name.substring(1);
		}

		if (fileName.length() == 0) {
			if (!dirName.equals("/")) {
				dirName = dirName + "/";
			}

			return bundle.getEntry(dirName);
		}

		Enumeration<URL> enumeration = bundle.findEntries(
			dirName, fileName, false);

		if ((enumeration == null) || !enumeration.hasMoreElements()) {
			return null;
		}

		List<URL> list = Collections.list(enumeration);

		return list.get(list.size() - 1);
	}

}