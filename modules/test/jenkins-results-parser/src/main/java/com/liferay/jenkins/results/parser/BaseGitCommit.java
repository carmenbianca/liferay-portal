/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.Date;
import java.util.Objects;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseGitCommit implements GitCommit {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BaseGitCommit)) {
			return false;
		}

		if (Objects.equals(hashCode(), obj.hashCode())) {
			return true;
		}

		return false;
	}

	@Override
	public String getAbbreviatedSHA() {
		return _sha.substring(0, 7);
	}

	@Override
	public Date getCommitDate() {
		return new Date(_commitTime);
	}

	@Override
	public String getGitRepositoryName() {
		return _gitRepositoryName;
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public String getSHA() {
		return _sha;
	}

	@Override
	public GitCommit.Type getType() {
		return _type;
	}

	@Override
	public int hashCode() {
		JSONObject jsonObject = toJSONObject();

		String json = jsonObject.toString();

		return json.hashCode();
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("commitTime", _commitTime);
		jsonObject.put("message", _message);
		jsonObject.put("sha", _sha);

		return jsonObject;
	}

	protected BaseGitCommit(
		String gitRepositoryName, String message, String sha,
		GitCommit.Type type, long commitTime) {

		_gitRepositoryName = gitRepositoryName;
		_message = message;
		_sha = sha;
		_type = type;
		_commitTime = commitTime;
	}

	private final long _commitTime;
	private final String _gitRepositoryName;
	private final String _message;
	private final String _sha;
	private final GitCommit.Type _type;

}