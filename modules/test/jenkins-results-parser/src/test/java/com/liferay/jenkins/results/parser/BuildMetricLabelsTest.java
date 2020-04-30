/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author Peter Yoo
 */
public class BuildMetricLabelsTest extends BuildTest {

	@Test
	public void testMetricLabelGeneration() throws Exception {
		expectedMessageGenerator = new ExpectedMessageGenerator() {

			@Override
			public String getMessage(TestSample testSample) {
				StringBuilder sb = new StringBuilder();

				Build build = BuildFactory.newBuildFromArchive(
					testSample.getSampleDirName());

				sb.append(_getMetricLabelsString(build));

				List<Build> downstreamBuilds = build.getDownstreamBuilds(null);

				for (Build downstreamBuild : downstreamBuilds) {
					sb.append(_getMetricLabelsString(downstreamBuild));
				}

				return sb.toString();
			}

		};

		assertSamples();
	}

	@Override
	protected File getExpectedMessageFile(TestSample testSample) {
		return new File(testSample.getSampleDir(), "expected-metric-labels");
	}

	private String _getMetricLabelsString(Build build) {
		Map<String, String> metricLabels = build.getMetricLabels();

		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, String> metricLabel : metricLabels.entrySet()) {
			sb.append(build.getJobName());
			sb.append("_");

			String jobVariant = build.getJobVariant();

			if ((jobVariant != null) && !jobVariant.equals("")) {
				sb.append(jobVariant);
				sb.append("_");
			}

			sb.append(metricLabel.getKey());
			sb.append("=");
			sb.append(metricLabel.getValue());
			sb.append("\n");
		}

		return sb.toString();
	}

}