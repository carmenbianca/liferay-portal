/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.workspace.internal.util;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.gradle.api.UncheckedIOException;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.tasks.SourceSet;

/**
 * @author Andrea Di Giorgi
 */
public class FileUtil extends com.liferay.gradle.util.FileUtil {

	public static File getJavaClassesDir(SourceSet sourceSet) {
		SourceDirectorySet sourceDirectorySet = sourceSet.getJava();

		return sourceDirectorySet.getOutputDir();
	}

	public static void moveTree(File sourceRootDir, File destinationRootDir) {
		try {
			_moveTree(sourceRootDir.toPath(), destinationRootDir.toPath());
		}
		catch (IOException ioException) {
			throw new UncheckedIOException(ioException);
		}
	}

	public static String read(File file) {
		try {
			return new String(
				Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
		}
		catch (IOException ioException) {
			throw new UncheckedIOException(ioException);
		}
	}

	private static void _moveTree(
			final Path sourceRootDirPath, final Path destinationRootDirPath)
		throws IOException {

		Files.walkFileTree(
			sourceRootDirPath,
			new SimpleFileVisitor<Path>() {

				@Override
				public FileVisitResult postVisitDirectory(
						Path dirPath, IOException ioException)
					throws IOException {

					Files.delete(dirPath);

					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult preVisitDirectory(
						Path dirPath, BasicFileAttributes basicFileAttributes)
					throws IOException {

					Path relativePath = sourceRootDirPath.relativize(dirPath);

					Path destinationDirPath = destinationRootDirPath.resolve(
						relativePath);

					Files.createDirectories(destinationDirPath);

					return FileVisitResult.CONTINUE;
				}

			});
	}

}