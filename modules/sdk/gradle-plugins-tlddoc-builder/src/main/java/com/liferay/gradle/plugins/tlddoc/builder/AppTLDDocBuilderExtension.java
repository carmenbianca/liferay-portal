/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.tlddoc.builder;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.gradle.api.Project;
import org.gradle.util.GUtil;

/**
 * @author Andrea Di Giorgi
 */
public class AppTLDDocBuilderExtension {

	public AppTLDDocBuilderExtension(Project project) {
		_subprojects.addAll(project.getSubprojects());
	}

	public Set<Project> getSubprojects() {
		return _subprojects;
	}

	public void setSubprojects(Iterable<Project> subprojects) {
		_subprojects.clear();

		subprojects(subprojects);
	}

	public void setSubprojects(Project... subprojects) {
		setSubprojects(Arrays.asList(subprojects));
	}

	public AppTLDDocBuilderExtension subprojects(
		Iterable<Project> subprojects) {

		GUtil.addToCollection(_subprojects, subprojects);

		return this;
	}

	public AppTLDDocBuilderExtension subprojects(Project... subprojects) {
		return subprojects(Arrays.asList(subprojects));
	}

	private final Set<Project> _subprojects = new LinkedHashSet<>();

}