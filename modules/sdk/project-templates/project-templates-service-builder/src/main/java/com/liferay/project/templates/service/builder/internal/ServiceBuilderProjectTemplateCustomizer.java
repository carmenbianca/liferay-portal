/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.project.templates.service.builder.internal;

import com.liferay.project.templates.extensions.ProjectTemplateCustomizer;
import com.liferay.project.templates.extensions.ProjectTemplatesArgs;
import com.liferay.project.templates.extensions.util.WorkspaceUtil;

import java.io.File;

import java.nio.file.Path;

import java.util.Properties;

import org.apache.maven.archetype.ArchetypeGenerationRequest;
import org.apache.maven.archetype.ArchetypeGenerationResult;

/**
 * @author Gregory Amerson
 */
public class ServiceBuilderProjectTemplateCustomizer
	implements ProjectTemplateCustomizer {

	@Override
	public String getTemplateName() {
		return "service-builder";
	}

	@Override
	public void onAfterGenerateProject(
			ProjectTemplatesArgs projectTemplatesArgs, File destinationDir,
			ArchetypeGenerationResult archetypeGenerationResult)
		throws Exception {
	}

	@Override
	public void onBeforeGenerateProject(
			ProjectTemplatesArgs projectTemplatesArgs,
			ArchetypeGenerationRequest archetypeGenerationRequest)
		throws Exception {

		String artifactId = archetypeGenerationRequest.getArtifactId();

		String apiPath = ":" + artifactId + "-api";

		File destinationDir = new File(
			archetypeGenerationRequest.getOutputDirectory());

		File workspaceDir = WorkspaceUtil.getWorkspaceDir(destinationDir);

		if (workspaceDir != null) {
			Path destinationDirPath = destinationDir.toPath();
			Path workspaceDirPath = workspaceDir.toPath();

			destinationDirPath = destinationDirPath.toAbsolutePath();
			workspaceDirPath = workspaceDirPath.toAbsolutePath();

			String relativePath = String.valueOf(
				workspaceDirPath.relativize(destinationDirPath));

			relativePath = relativePath.replace(File.separatorChar, ':');

			apiPath = ":" + relativePath + ":" + artifactId + apiPath;
		}

		Properties properties = archetypeGenerationRequest.getProperties();

		setProperty(properties, "apiPath", apiPath);

		ServiceBuilderProjectTemplatesArgs serviceBuilderProjectTemplatesArgs =
			(ServiceBuilderProjectTemplatesArgs)
				projectTemplatesArgs.getProjectTemplatesArgsExt();

		setProperty(
			properties, "dependencyInjector",
			serviceBuilderProjectTemplatesArgs.getDependencyInjector());
	}

}