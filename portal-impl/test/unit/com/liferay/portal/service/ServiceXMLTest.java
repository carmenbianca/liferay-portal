/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service;

import java.io.IOException;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.Objects;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Preston Crary
 */
public class ServiceXMLTest {

	@Test
	public void testTXRequired() throws Exception {
		Stream<Path> stream = Files.find(
			Paths.get(System.getProperty("user.dir")), Integer.MAX_VALUE,
			ServiceXMLTest::_isServiceXml, FileVisitOption.FOLLOW_LINKS);

		stream.forEach(ServiceXMLTest::_assertNoTXRequiredElement);
	}

	private static void _assertNoTXRequiredElement(Path path) {
		try {
			Stream<String> stream = Files.lines(path);

			Assert.assertFalse(
				"Remove deprecated tx-required element from " + path,
				stream.anyMatch(line -> line.contains("<tx-required>")));
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	private static boolean _isServiceXml(
		Path path, BasicFileAttributes basicFileAttributes) {

		Path fileNamePath = path.getFileName();

		if (Objects.equals(fileNamePath.toString(), "service.xml")) {
			return true;
		}

		return false;
	}

}