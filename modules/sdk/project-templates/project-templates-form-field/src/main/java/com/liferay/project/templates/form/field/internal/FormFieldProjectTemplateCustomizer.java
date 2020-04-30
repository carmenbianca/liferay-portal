/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.project.templates.form.field.internal;

import com.liferay.project.templates.extensions.ProjectTemplateCustomizer;
import com.liferay.project.templates.extensions.ProjectTemplatesArgs;

import java.io.File;

import java.nio.file.Path;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.archetype.ArchetypeGenerationRequest;
import org.apache.maven.archetype.ArchetypeGenerationResult;

/**
 * @author Renato Rego
 */
public class FormFieldProjectTemplateCustomizer
	implements ProjectTemplateCustomizer {

	@Override
	public String getTemplateName() {
		return "form-field";
	}

	@Override
	public void onAfterGenerateProject(
			ProjectTemplatesArgs projectTemplatesArgs, File destinationDir,
			ArchetypeGenerationResult archetypeGenerationResult)
		throws Exception {

		String liferayVersion = projectTemplatesArgs.getLiferayVersion();

		if (!liferayVersion.startsWith("7.1")) {
			Path destinationDirPath = destinationDir.toPath();

			String name = projectTemplatesArgs.getName();

			Path projectDirPath = destinationDirPath.resolve(name);

			List<String> fileNames = new ArrayList<>();

			fileNames.add(".babelrc");
			fileNames.add(".npmbundlerrc");
			fileNames.add("package.json");
			fileNames.add(
				"src/main/resources/META-INF/resources/" + name + ".es.js");

			for (String fileName : fileNames) {
				ProjectTemplateCustomizer.deleteFileInPath(
					fileName, projectDirPath);
			}
		}
	}

	@Override
	public void onBeforeGenerateProject(
			ProjectTemplatesArgs projectTemplatesArgs,
			ArchetypeGenerationRequest archetypeGenerationRequest)
		throws Exception {
	}

}