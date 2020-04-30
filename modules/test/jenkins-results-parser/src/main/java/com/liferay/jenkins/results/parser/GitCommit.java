/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.Date;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public interface GitCommit {

	@Override
	public boolean equals(Object o);

	public String getAbbreviatedSHA();

	public Date getCommitDate();

	public String getGitRepositoryName();

	public String getMessage();

	public String getSHA();

	public GitCommit.Type getType();

	public JSONObject toJSONObject();

	public enum Type {

		LEGACY_ARCHIVE, MANUAL

	}

}