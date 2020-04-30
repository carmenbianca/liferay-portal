/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.net.URL;

import java.util.Properties;
import java.util.regex.Pattern;

import org.json.JSONObject;

/**
 * @author Leslie Wong
 * @author Michael Hashimoto
 */
public interface BuildDatabase {

	public static final String FILE_NAME_BUILD_DATABASE = "build-database.json";

	public File getBuildDatabaseJSFile();

	public JSONObject getBuildDataJSONObject(String key);

	public JSONObject getBuildDataJSONObject(URL buildURL);

	public Properties getProperties(String key);

	public Properties getProperties(String key, Pattern pattern);

	public WorkspaceGitRepository getWorkspaceGitRepository(String key);

	public boolean hasBuildData(String key);

	public boolean hasProperties(String key);

	public boolean hasWorkspaceGitRepository(String key);

	public void putBuildData(String key, BuildData buildData);

	public void putProperties(String key, File propertiesFile);

	public void putProperties(String key, Properties properties);

	public void putWorkspaceGitRepository(
		String key, WorkspaceGitRepository workspaceGitRepository);

	public void writeFilteredPropertiesToFile(
		String destFilePath, Pattern pattern, String key);

	public void writePropertiesToFile(String destFilePath, String key);

}