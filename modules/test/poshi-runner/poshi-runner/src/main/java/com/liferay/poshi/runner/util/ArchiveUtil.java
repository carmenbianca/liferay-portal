/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Kenji Heigel
 */
public class ArchiveUtil {

	public static void archive(File sourceFile, File targetFile) {
		String targetFileName = targetFile.getName();

		if (!(targetFileName.endsWith(".jar") ||
			  targetFileName.endsWith(".lar") ||
			  targetFileName.endsWith(".war") ||
			  targetFileName.endsWith(".zip"))) {

			throw new RuntimeException("Invalid archive path " + targetFile);
		}

		targetFile.delete();

		File parentFile = targetFile.getParentFile();

		parentFile.mkdirs();

		File tmpDir = new File(sourceFile.getParentFile(), "tmp");

		tmpDir.mkdir();

		tmpDir.deleteOnExit();

		File tmpFile = new File(tmpDir, targetFileName);

		tmpFile.delete();

		try (ZipOutputStream zipOutputStream = new ZipOutputStream(
				new FileOutputStream(tmpFile))) {

			Path sourceFilePath = Paths.get(sourceFile.getCanonicalPath());

			Files.walkFileTree(
				sourceFilePath,
				new SimpleFileVisitor<Path>() {

					@Override
					public FileVisitResult visitFile(
						Path file, BasicFileAttributes attributes) {

						try {
							Path targetFilePath = sourceFilePath.relativize(
								file);

							String targetFilePathString =
								targetFilePath.toString();

							targetFilePathString = StringUtil.replace(
								targetFilePathString, "\\", "/");

							zipOutputStream.putNextEntry(
								new ZipEntry(targetFilePathString));

							byte[] bytes = Files.readAllBytes(file);

							zipOutputStream.write(bytes, 0, bytes.length);

							zipOutputStream.closeEntry();
						}
						catch (IOException ioException) {
							ioException.printStackTrace();
						}

						return FileVisitResult.CONTINUE;
					}

				});

			Files.move(
				Paths.get(tmpFile.getCanonicalPath()),
				Paths.get(targetFile.getCanonicalPath()));
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to archive " + sourceFile + " to " + targetFile,
				ioException);
		}
	}

	public static void archive(String sourceFilePath, String targetFilePath) {
		archive(new File(sourceFilePath), new File(targetFilePath));
	}

	public static void archive(
		String sourceFile, String targetDir, String archiveType) {

		Path sourceDirPath = Paths.get(sourceFile);

		String archiveFilePath =
			targetDir + "/" + sourceDirPath.getFileName() + "." + archiveType;

		archive(sourceFile, archiveFilePath);
	}

}