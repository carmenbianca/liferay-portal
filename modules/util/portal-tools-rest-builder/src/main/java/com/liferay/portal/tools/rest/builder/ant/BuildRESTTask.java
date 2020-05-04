/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.rest.builder.ant;

import com.liferay.portal.tools.rest.builder.RESTBuilder;
import com.liferay.portal.tools.rest.builder.RESTBuilderArgs;

import org.apache.tools.ant.BuildException;

/**
 * @author Peter Shin
 */
public class BuildRESTTask extends RESTBuilderArgs {

	public void execute() {
		try {
			RESTBuilder restBuilder = new RESTBuilder(this);

			restBuilder.build();
		}
		catch (Exception exception) {
			throw new BuildException(exception);
		}
	}

}