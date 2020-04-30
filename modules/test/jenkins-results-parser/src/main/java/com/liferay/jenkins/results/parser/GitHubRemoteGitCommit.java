/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class GitHubRemoteGitCommit extends BaseGitCommit {

	public String getGitHubCommitURL() {
		return JenkinsResultsParserUtil.combine(
			"https://github.com/", _gitHubUsername, "/", getGitRepositoryName(),
			"/commit/", getSHA());
	}

	public void setStatus(
		Status status, String context, String description, String targetURL) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("state", StringUtils.lowerCase(status.toString()));

		if (context != null) {
			jsonObject.put("context", context);
		}

		if (description != null) {
			jsonObject.put("description", description);
		}

		if ((targetURL != null) && targetURL.matches("https?\\:\\/\\/.*")) {
			jsonObject.put("target_url", targetURL);
		}

		try {
			JenkinsResultsParserUtil.toJSONObject(
				getGitHubStatusURL(), jsonObject.toString());
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	public enum Status {

		ERROR, FAILURE, PENDING, SUCCESS

	}

	protected GitHubRemoteGitCommit(
		String gitHubUsername, String gitRepositoryName, String message,
		String sha, Type type, long commitTime) {

		super(gitRepositoryName, message, sha, type, commitTime);

		_gitHubUsername = gitHubUsername;
	}

	protected String getGitHubStatusURL() {
		return JenkinsResultsParserUtil.getGitHubApiUrl(
			getGitRepositoryName(), _gitHubUsername, "statuses/" + getSHA());
	}

	private final String _gitHubUsername;

}