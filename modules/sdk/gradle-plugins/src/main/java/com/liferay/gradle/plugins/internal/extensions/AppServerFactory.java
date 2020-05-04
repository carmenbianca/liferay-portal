/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal.extensions;

import com.liferay.gradle.plugins.extensions.AppServer;
import com.liferay.gradle.plugins.extensions.JOnASAppServer;
import com.liferay.gradle.plugins.extensions.TomcatAppServer;

import org.gradle.api.NamedDomainObjectFactory;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class AppServerFactory implements NamedDomainObjectFactory<AppServer> {

	public AppServerFactory(Project project) {
		_project = project;
	}

	@Override
	public AppServer create(String name) {
		if (name.equals("jonas")) {
			return new JOnASAppServer(_project);
		}
		else if (name.equals("tomcat")) {
			return new TomcatAppServer(_project);
		}

		return new AppServer(name, _project);
	}

	private final Project _project;

}