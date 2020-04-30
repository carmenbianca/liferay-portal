/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class FreestyleBatchBuild extends BatchBuild {

	@Override
	public void addTimelineData(BaseBuild.TimelineData timelineData) {
		timelineData.addTimelineData(this);
	}

	protected FreestyleBatchBuild(String url) {
		this(url, null);
	}

	protected FreestyleBatchBuild(String url, TopLevelBuild topLevelBuild) {
		super(url, topLevelBuild);
	}

}