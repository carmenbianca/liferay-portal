/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.project.templates.service.internal;

import com.beust.jcommander.Parameter;

import com.liferay.project.templates.extensions.ProjectTemplatesArgsExt;

/**
 * @author Gregory Amerson
 */
public class ServiceProjectTemplatesArgs implements ProjectTemplatesArgsExt {

	public String getService() {
		return _service;
	}

	@Override
	public String getTemplateName() {
		return "service";
	}

	public void setService(String service) {
		_service = service;
	}

	@Parameter(
		description = "Provide the name of the service to be implemented.",
		names = "--service", required = true
	)
	private String _service;

}