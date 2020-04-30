/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.List;

/**
 * @author Michael Hashimoto
 */
public interface TopLevelBuildData extends BuildData {

	public void addDownstreamBuildData(BuildData buildData);

	public List<String> getDistNodes();

	public String getDistPath();

	public List<BuildData> getDownstreamBuildDataList();

	public void setDistNodes(List<String> distNodes);

}