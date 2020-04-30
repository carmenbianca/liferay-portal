/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author Michael Hashimoto
 */
public interface Job {

	public Set<String> getBatchNames();

	public List<Build> getBuildHistory(JenkinsMaster jenkinsMaster);

	public Set<String> getDistTypes();

	public String getJobName();

	public Properties getJobProperties();

	public String getJobProperty(String key);

	public String getJobURL(JenkinsMaster jenkinsMaster);

	public void readJobProperties();

}