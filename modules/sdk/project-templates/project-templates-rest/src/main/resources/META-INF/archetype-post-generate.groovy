/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
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

if (liferayVersion.startsWith("7.1") || liferayVersion.startsWith("7.2") || liferayVersion.startsWith("7.3")) {
	Path configPath = projectPath.resolve("src/main/resources/configuration")

	String cxfConfig =
		"com.liferay.portal.remote.cxf.common.configuration." +
			"CXFEndpointPublisherConfiguration-cxf.properties";

	Path cxfConfigPath = configPath.resolve(cxfConfig)

	Files.deleteIfExists cxfConfigPath

	String restExtenderConfig =
		"com.liferay.portal.remote.rest.extender.configuration." +
			"RestExtenderConfiguration-rest.properties";

	Path restExtenderConfigPath = configPath.resolve(restExtenderConfig)

	Files.deleteIfExists restExtenderConfigPath

	Files.deleteIfExists configPath
}