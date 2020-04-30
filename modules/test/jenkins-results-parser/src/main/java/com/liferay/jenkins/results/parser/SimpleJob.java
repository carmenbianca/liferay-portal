/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael Hashimoto
 */
public class SimpleJob extends BaseJob {

	@Override
	public Set<String> getBatchNames() {
		return new HashSet<>();
	}

	@Override
	public Set<String> getDistTypes() {
		return new HashSet<>();
	}

	protected SimpleJob(String jobName) {
		super(jobName);
	}

}