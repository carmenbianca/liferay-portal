/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.deploy;

/**
 * @author Jeyvison Nascimento
 * @author Gabriel Albuquerque
 */
public interface AppDeployerTracker {

	public AppDeployer getAppDeployer(String type);

}