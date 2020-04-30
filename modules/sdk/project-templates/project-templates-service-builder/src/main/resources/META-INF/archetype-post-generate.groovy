/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

Path apiPath = projectPath.resolve(request.artifactId + "-api")
Path buildGradlePath = projectPath.resolve("build.gradle")
Path servicePath = projectPath.resolve(request.artifactId + "-service")

Path apiBuildGradlePath = apiPath.resolve("build.gradle")
Path serviceBuildGradlePath = servicePath.resolve("build.gradle")
Path serviceBuildSettingsPath = projectPath.resolve("settings.gradle")

Files.deleteIfExists apiBuildGradlePath
Files.deleteIfExists buildGradlePath
Files.deleteIfExists serviceBuildGradlePath
Files.deleteIfExists serviceBuildSettingsPath