/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.spira;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil.HttpRequestMethod;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class SpiraRestAPIUtil {

	protected static String request(
			String urlPath, Map<String, String> urlParameters,
			Map<String, String> urlPathReplacements,
			HttpRequestMethod httpRequestMethod, String requestData)
		throws IOException {

		String spiraBaseURL = _SPIRA_BASE_URL;

		if (urlPath.contains("/test-sets/search")) {
			spiraBaseURL = spiraBaseURL.replace("v6_0", "v5_0");
		}

		return JenkinsResultsParserUtil.toString(
			JenkinsResultsParserUtil.combine(
				spiraBaseURL,
				_applyURLPathReplacements(urlPath, urlPathReplacements),
				_toURLParametersString(urlParameters)),
			false, httpRequestMethod, requestData);
	}

	protected static JSONArray requestJSONArray(
			String urlPath, Map<String, String> urlParameters,
			Map<String, String> urlPathReplacements,
			HttpRequestMethod httpRequestMethod, String requestData)
		throws IOException {

		return JenkinsResultsParserUtil.createJSONArray(
			request(
				urlPath, urlParameters, urlPathReplacements, httpRequestMethod,
				requestData));
	}

	protected static JSONObject requestJSONObject(
			String urlPath, Map<String, String> urlParameters,
			Map<String, String> urlPathReplacements,
			HttpRequestMethod httpRequestMethod, String requestData)
		throws IOException {

		return JenkinsResultsParserUtil.createJSONObject(
			request(
				urlPath, urlParameters, urlPathReplacements, httpRequestMethod,
				requestData));
	}

	private static String _applyURLPathReplacements(
		String urlPath, Map<String, String> urlPathReplacements) {

		if (urlPath == null) {
			return "";
		}

		if (urlPathReplacements != null) {
			for (Map.Entry<String, String> urlPathReplacement :
					urlPathReplacements.entrySet()) {

				urlPath = urlPath.replace(
					"{" + urlPathReplacement.getKey() + "}",
					urlPathReplacement.getValue());
			}
		}

		if (urlPath.matches(".*\\{[^\\}]+\\}.*")) {
			throw new RuntimeException("Invalid url path " + urlPath);
		}

		if (urlPath.contains("?")) {
			throw new RuntimeException("Invalid url path " + urlPath);
		}

		if (!urlPath.startsWith("/")) {
			urlPath = "/" + urlPath;
		}

		return urlPath;
	}

	private static String _toURLParametersString(
		Map<String, String> urlParameters) {

		if ((urlParameters == null) || urlParameters.isEmpty()) {
			return "";
		}

		List<String> urlParameterStrings = new ArrayList<>();

		for (Map.Entry<String, String> urlParameter :
				urlParameters.entrySet()) {

			urlParameterStrings.add(
				urlParameter.getKey() + "=" + urlParameter.getValue());
		}

		return "?" + JenkinsResultsParserUtil.join("&", urlParameterStrings);
	}

	private static final String _SPIRA_BASE_URL =
		"https://liferay.spiraservice.net/services/v6_0/RestService.svc";

}