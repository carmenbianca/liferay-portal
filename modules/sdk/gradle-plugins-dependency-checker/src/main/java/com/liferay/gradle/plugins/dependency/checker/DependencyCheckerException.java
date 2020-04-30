/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.dependency.checker;

import org.gradle.api.GradleException;

/**
 * @author Andrea Di Giorgi
 */
public class DependencyCheckerException extends GradleException {

	public DependencyCheckerException(String message) {
		super(message);
	}

}