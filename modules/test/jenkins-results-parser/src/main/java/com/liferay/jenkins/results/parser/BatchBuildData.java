/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.List;

/**
 * @author Michael Hashimoto
 */
public interface BatchBuildData extends BuildData {

	public String getBatchName();

	public List<String> getTestList();

	public void setBatchName(String batchName);

	public void setTestList(List<String> testList);

}