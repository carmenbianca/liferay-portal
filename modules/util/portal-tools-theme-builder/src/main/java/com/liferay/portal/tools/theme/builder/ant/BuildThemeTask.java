/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.theme.builder.ant;

import com.liferay.portal.tools.theme.builder.ThemeBuilder;
import com.liferay.portal.tools.theme.builder.ThemeBuilderArgs;

import org.apache.tools.ant.BuildException;

/**
 * @author Andrea Di Giorgi
 */
public class BuildThemeTask extends ThemeBuilderArgs {

	public void execute() {
		try {
			ThemeBuilder themeBuilder = new ThemeBuilder(this);

			themeBuilder.build();
		}
		catch (Exception exception) {
			throw new BuildException(exception);
		}
	}

}