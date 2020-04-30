/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.spira;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class PathSpiraArtifact extends BaseSpiraArtifact {

	public String getPath() {
		String name = getName();

		name = name.replace("/", "\\/");

		PathSpiraArtifact parentSpiraArtifact = getParentSpiraArtifact();

		if (parentSpiraArtifact == null) {
			return "/" + name;
		}

		return JenkinsResultsParserUtil.combine(
			parentSpiraArtifact.getPath(), "/", name);
	}

	protected static String getParentPath(String path) {
		_validatePath(path);

		return path.substring(
			0, JenkinsResultsParserUtil.lastIndexOfRegex(path, "(?<!\\\\)\\/"));
	}

	protected static String getPathName(String path) {
		_validatePath(path);

		return path.substring(
			JenkinsResultsParserUtil.lastIndexOfRegex(path, "(?<!\\\\)\\/") +
				1);
	}

	protected PathSpiraArtifact(JSONObject jsonObject) {
		super(jsonObject);

		this.jsonObject.put("Path", getPath());
	}

	protected abstract PathSpiraArtifact getParentSpiraArtifact();

	private static void _validatePath(String path) {
		if (path.endsWith("/") || !path.startsWith("/")) {
			throw new RuntimeException("Invalid path " + path);
		}
	}

}