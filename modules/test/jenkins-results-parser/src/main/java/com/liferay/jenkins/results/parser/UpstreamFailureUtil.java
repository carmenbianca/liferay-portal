/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Kenji Heigel
 */
public class UpstreamFailureUtil {

	public static List<String> getUpstreamJobFailures(
		String type, TopLevelBuild topLevelBuild) {

		List<String> upstreamFailures = new ArrayList<>();

		JSONObject upstreamJobFailuresJSONObject =
			getUpstreamJobFailuresJSONObject(topLevelBuild);

		JSONArray failedBatchesJSONArray =
			upstreamJobFailuresJSONObject.getJSONArray("failedBatches");

		for (int i = 0; i < failedBatchesJSONArray.length(); i++) {
			JSONObject failedBatchJSONObject =
				failedBatchesJSONArray.getJSONObject(i);

			JSONArray failedTestsJSONArray = failedBatchJSONObject.getJSONArray(
				"failedTests");

			String jobVariant = failedBatchJSONObject.getString("jobVariant");

			if (type.equals("build")) {
				if (failedTestsJSONArray.length() == 0) {
					upstreamFailures.add(
						JenkinsResultsParserUtil.combine(
							jobVariant, ",",
							failedBatchJSONObject.getString("result")));
				}
			}
			else if (type.equals("test")) {
				for (int j = 0; j < failedTestsJSONArray.length(); j++) {
					Object object = failedTestsJSONArray.get(j);

					upstreamFailures.add(
						JenkinsResultsParserUtil.combine(
							object.toString(), ",", jobVariant));
				}
			}
		}

		return upstreamFailures;
	}

	public static JSONObject getUpstreamJobFailuresJSONObject(
		TopLevelBuild topLevelBuild) {

		if (_upstreamFailuresJobJSONObject == null) {
			loadUpstreamJobFailuresJSONObject(topLevelBuild);
		}

		return _upstreamFailuresJobJSONObject;
	}

	public static String getUpstreamJobFailuresSHA(
		TopLevelBuild topLevelBuild) {

		try {
			JSONObject upstreamJobFailuresJSONObject =
				getUpstreamJobFailuresJSONObject(topLevelBuild);

			return upstreamJobFailuresJSONObject.getString("SHA");
		}
		catch (JSONException jsonException) {
			System.out.println(
				"Unable to get upstream acceptance failure data");

			jsonException.printStackTrace();

			return "";
		}
	}

	public static boolean isBuildFailingInUpstreamJob(Build build) {
		if (!isUpstreamComparisonAvailable()) {
			return false;
		}

		try {
			List<TestResult> testResults = new ArrayList<>();

			testResults.addAll(build.getTestResults("FAILED"));
			testResults.addAll(build.getTestResults("REGRESSION"));

			if (testResults.isEmpty()) {
				String jobVariant = build.getJobVariant();

				if (jobVariant == null) {
					return false;
				}

				String result = build.getResult();

				if (result == null) {
					return false;
				}

				if (jobVariant.contains("/")) {
					int index = jobVariant.lastIndexOf("/");

					jobVariant = jobVariant.substring(0, index);
				}

				TopLevelBuild topLevelBuild = build.getTopLevelBuild();

				for (String upstreamJobFailure :
						getUpstreamJobFailures("build", topLevelBuild)) {

					if (upstreamJobFailure.contains(jobVariant) &&
						upstreamJobFailure.contains(result)) {

						return true;
					}
				}
			}

			return false;
		}
		catch (Exception exception) {
			System.out.println(
				"Unable to get upstream acceptance failure data.");

			exception.printStackTrace();

			return false;
		}
	}

	public static boolean isTestFailingInUpstreamJob(TestResult testResult) {
		if (!isUpstreamComparisonAvailable()) {
			return false;
		}

		Build build = testResult.getBuild();

		TopLevelBuild topLevelBuild = build.getTopLevelBuild();

		try {
			for (String failure :
					getUpstreamJobFailures("test", topLevelBuild)) {

				String jobVariant = build.getJobVariant();

				if (jobVariant.contains("/")) {
					int index = jobVariant.lastIndexOf("/");

					jobVariant = jobVariant.substring(0, index);
				}

				if (failure.contains(jobVariant) &&
					failure.contains(testResult.getDisplayName())) {

					return true;
				}
			}

			return false;
		}
		catch (Exception exception) {
			System.out.println(
				"Unable to get upstream acceptance failure data.");

			exception.printStackTrace();

			return false;
		}
	}

	public static boolean isUpstreamComparisonAvailable() {
		return _upstreamComparisonAvailable;
	}

	public static void loadUpstreamJobFailuresJSONObject(
		TopLevelBuild topLevelBuild) {

		String jobName = topLevelBuild.getJobName();

		if (!jobName.contains("pullrequest") ||
			!topLevelBuild.isCompareToUpstream()) {

			_upstreamFailuresJobJSONObject = new JSONObject(
				"{\"SHA\":\"\",\"failedBatches\":[]}");

			return;
		}

		String url = JenkinsResultsParserUtil.getLocalURL(
			JenkinsResultsParserUtil.combine(
				_URL_BASE_UPSTREAM_FAILURES_JOB,
				jobName.replace("pullrequest", "upstream-dxp"),
				"/builds/latest/test.results.json"));

		try {
			Properties buildProperties =
				JenkinsResultsParserUtil.getBuildProperties();

			String jenkinsDirName = buildProperties.getProperty(
				"jenkins.dir[master]");

			File upstreamJobFailuresJSONFile = new File(
				jenkinsDirName, "upstream-failures.json");

			if (upstreamJobFailuresJSONFile.exists()) {
				String fileContent = JenkinsResultsParserUtil.read(
					upstreamJobFailuresJSONFile);

				_upstreamFailuresJobJSONObject = new JSONObject(fileContent);
			}
			else {
				_upstreamFailuresJobJSONObject =
					JenkinsResultsParserUtil.toJSONObject(url, false, 5000);
			}

			System.out.println(
				"Using upstream failures at: " +
					getUpstreamJobFailuresSHA(topLevelBuild));
		}
		catch (Exception exception) {
			System.out.println(exception);

			System.out.println(
				"Unable to load upstream acceptance failure data from URL: " +
					url);

			_upstreamFailuresJobJSONObject = new JSONObject(
				"{\"SHA\":\"\",\"failedBatches\":[]}");

			_upstreamComparisonAvailable = false;
		}
	}

	private static final String _URL_BASE_UPSTREAM_FAILURES_JOB =
		"https://test-1-0.liferay.com/userContent/testResults/";

	private static boolean _upstreamComparisonAvailable = true;
	private static JSONObject _upstreamFailuresJobJSONObject;

}