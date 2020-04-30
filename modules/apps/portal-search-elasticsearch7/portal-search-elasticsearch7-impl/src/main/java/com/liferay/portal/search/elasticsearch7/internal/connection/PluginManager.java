/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import java.io.IOException;

import java.nio.file.Path;

/**
 * @author Artur Aquino
 * @author André de Oliveira
 */
public interface PluginManager {

	public Path[] getInstalledPluginsPaths() throws IOException;

	public void install(String name) throws Exception;

	public boolean isCurrentVersion(Path path) throws IOException;

	public void remove(String name) throws Exception;

}