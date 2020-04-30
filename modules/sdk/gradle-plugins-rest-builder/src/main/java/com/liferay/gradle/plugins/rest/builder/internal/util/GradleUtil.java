/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.rest.builder.internal.util;

import java.util.Set;

import org.gradle.api.Project;

/**
 * @author Peter Shin
 */
public class GradleUtil extends com.liferay.gradle.util.GradleUtil {

	public static Project findProject(Project rootProject, String name) {
		for (Project project : rootProject.getAllprojects()) {
			if (name.equals(project.getName())) {
				Set<Project> subprojects = project.getSubprojects();

				if (subprojects.isEmpty()) {
					return project;
				}
			}
		}

		return null;
	}

}