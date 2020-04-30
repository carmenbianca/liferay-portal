/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class DefaultBatchBuildData extends BaseBatchBuildData {

	protected DefaultBatchBuildData(
		String runID, String jobName, String buildURL) {

		super(runID, jobName, buildURL);
	}

	@Override
	protected String getType() {
		return _TYPE;
	}

	private static final String _TYPE = "batch";

}