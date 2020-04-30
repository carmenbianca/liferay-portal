/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

Path buildGradlePath = projectPath.resolve("build.gradle")

Files.deleteIfExists buildGradlePath

Properties properties = request.properties

String liferayVersion = properties.get("liferayVersion")

if (!liferayVersion.startsWith("7.1")) {
	String artifactId = properties.get("artifactId")

	List<String> fileNames = [".babelrc", ".npmbundlerrc", "package.json", "src/main/resources/META-INF/resources/${artifactId}.es.js"]

	for (fileName in fileNames) {
		Path resourcePath = Paths.get(fileName)

		Path resourceFullPath = projectPath.resolve(resourcePath)

		Files.deleteIfExists resourceFullPath
	}
}