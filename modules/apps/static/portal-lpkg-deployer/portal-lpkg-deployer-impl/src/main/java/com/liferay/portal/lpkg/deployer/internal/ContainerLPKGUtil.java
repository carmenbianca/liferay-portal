/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer.internal;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PropsValues;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.osgi.framework.BundleContext;

/**
 * @author Matthew Tambara
 */
public class ContainerLPKGUtil {

	public static List<File> deploy(
			File lpkgFile, BundleContext bundleContext, Properties properties)
		throws IOException {

		Path deployerDirPath = Paths.get(
			GetterUtil.getString(
				bundleContext.getProperty("lpkg.deployer.dir"),
				PropsValues.MODULE_FRAMEWORK_MARKETPLACE_DIR));

		List<File> lpkgFiles = new ArrayList<>();

		try (ZipFile zipFile = new ZipFile(lpkgFile)) {
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();

			while (zipEntries.hasMoreElements()) {
				ZipEntry zipEntry = zipEntries.nextElement();

				String name = zipEntry.getName();

				if (!name.endsWith(".lpkg")) {
					if (properties != null) {
						zipEntry = zipFile.getEntry(
							"liferay-marketplace.properties");

						if (zipEntry != null) {
							try (InputStream inputStream =
									zipFile.getInputStream(zipEntry)) {

								properties.load(inputStream);
							}
						}
					}

					return null;
				}

				Path lpkgPath = deployerDirPath.resolve(name);

				Files.copy(
					zipFile.getInputStream(zipEntry), lpkgPath,
					StandardCopyOption.REPLACE_EXISTING);

				lpkgFiles.add(lpkgPath.toFile());
			}
		}

		if (lpkgFiles.isEmpty()) {
			return null;
		}

		lpkgFile.delete();

		return lpkgFiles;
	}

}