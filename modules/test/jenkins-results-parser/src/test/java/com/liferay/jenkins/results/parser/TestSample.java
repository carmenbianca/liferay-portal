/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.List;

/**
 * @author Peter Yoo
 */
public class TestSample {

	public TestSample(List<File> baseSamplesDirs, String sampleKey) {
		this.sampleKey = sampleKey;

		for (File baseSamplesDir : baseSamplesDirs) {
			sampleDir = new File(baseSamplesDir, sampleKey);

			if (!sampleDir.exists()) {
				sampleDir = null;

				continue;
			}

			sampleDirName = baseSamplesDir.getName() + "/" + sampleKey;

			break;
		}
	}

	public File getSampleDir() {
		return sampleDir;
	}

	public String getSampleDirName() {
		return sampleDirName;
	}

	public String getSampleKey() {
		return sampleKey;
	}

	protected File sampleDir;
	protected String sampleDirName;
	protected String sampleKey;

}