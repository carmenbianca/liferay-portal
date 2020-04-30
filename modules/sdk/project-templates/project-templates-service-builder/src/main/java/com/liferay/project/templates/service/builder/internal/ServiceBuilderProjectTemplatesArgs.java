/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.project.templates.service.builder.internal;

import com.beust.jcommander.Parameter;

import com.liferay.project.templates.extensions.ProjectTemplatesArgsExt;

/**
 * @author Gregory Amerson
 */
public class ServiceBuilderProjectTemplatesArgs
	implements ProjectTemplatesArgsExt {

	public String getDependencyInjector() {
		return _dependencyInjector;
	}

	@Override
	public String getTemplateName() {
		return "service-builder";
	}

	public void setDependencyInjector(String dependencyInjector) {
		_dependencyInjector = dependencyInjector;
	}

	@Parameter(
		description = "Specify the preferred dependency injection method. (ds|spring)",
		names = "--dependency-injector"
	)
	private String _dependencyInjector = "ds";

}