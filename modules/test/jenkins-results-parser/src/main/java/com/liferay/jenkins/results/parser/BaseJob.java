/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseJob implements Job {

	@Override
	public List<Build> getBuildHistory(JenkinsMaster jenkinsMaster) {
		JSONObject jobJSONObject = getJobJSONObject(
			jenkinsMaster, "builds[number]");

		JSONArray buildsJSONArray = jobJSONObject.getJSONArray("builds");

		List<Build> builds = new ArrayList<>(buildsJSONArray.length());

		for (int i = 0; i < buildsJSONArray.length(); i++) {
			JSONObject buildJSONObject = buildsJSONArray.getJSONObject(i);

			builds.add(
				BuildFactory.newBuild(
					JenkinsResultsParserUtil.combine(
						jenkinsMaster.getURL(), "/job/", getJobName(), "/",
						String.valueOf(buildJSONObject.getInt("number"))),
					null));
		}

		return builds;
	}

	@Override
	public String getJobName() {
		return _jobName;
	}

	@Override
	public Properties getJobProperties() {
		return _jobProperties;
	}

	@Override
	public String getJobProperty(String key) {
		return _jobProperties.getProperty(key);
	}

	public String getJobURL(JenkinsMaster jenkinsMaster) {
		return JenkinsResultsParserUtil.combine(
			jenkinsMaster.getURL(), "/job/", _jobName);
	}

	@Override
	public void readJobProperties() {
		_jobProperties.clear();

		for (File jobPropertiesFile : jobPropertiesFiles) {
			_jobProperties.putAll(
				JenkinsResultsParserUtil.getProperties(jobPropertiesFile));
		}
	}

	protected BaseJob(String jobName) {
		_jobName = jobName;
	}

	protected JSONObject getJobJSONObject(
		JenkinsMaster jenkinsMaster, String tree) {

		if (getJobURL(jenkinsMaster) == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();

		sb.append(
			JenkinsResultsParserUtil.getLocalURL(getJobURL(jenkinsMaster)));
		sb.append("/api/json?pretty");

		if (tree != null) {
			sb.append("&tree=");
			sb.append(tree);
		}

		try {
			return JenkinsResultsParserUtil.toJSONObject(sb.toString(), false);
		}
		catch (IOException ioException) {
			throw new RuntimeException("Unable to get job JSON", ioException);
		}
	}

	protected Set<String> getSetFromString(String string) {
		Set<String> set = new TreeSet<>();

		if (string == null) {
			return set;
		}

		for (String item : StringUtils.split(string, ",")) {
			if (item.startsWith("#")) {
				continue;
			}

			set.add(item.trim());
		}

		return set;
	}

	protected final List<File> jobPropertiesFiles = new ArrayList<>();

	private final String _jobName;
	private final Properties _jobProperties = new Properties();

}