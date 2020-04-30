/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import groovy.io.FileType

import java.nio.file.DirectoryStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

Path buildGradlePath = projectPath.resolve("build.gradle")

Files.deleteIfExists buildGradlePath

def buildDir = projectPath.toFile()
def viewsDir = new File(buildDir, "src/main/webapp/WEB-INF/views")
def spring4JavaPkgDir = new File(buildDir, "src/main/java/" + request.properties["package"].replaceAll("[.]", "/") + "/spring4")

if (request.properties["viewType"].equals("jsp")) {
	viewsDir.eachFileMatch FileType.FILES, ~/.*\.html/, {
		File viewFile -> viewFile.delete()
	}
}
else {
	viewsDir.eachFileMatch FileType.FILES, ~/.*\.jspx/, {
		File viewFile -> viewFile.delete()
	}
}

if (request.properties["viewType"].equals("jsp") ||
	request.properties["framework"].equals("portletmvc4spring")) {
	spring4JavaPkgDir.deleteDir()
}