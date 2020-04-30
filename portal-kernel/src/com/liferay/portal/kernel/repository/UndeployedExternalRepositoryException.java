/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository;

/**
 * @author Iván Zaera
 */
public class UndeployedExternalRepositoryException extends RepositoryException {

	public UndeployedExternalRepositoryException(String className) {
		super(
			"Unable to load external repository class " + className +
				" because its plugin is not deployed");

		this.className = className;
	}

	public final String className;

}