/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ant.build.logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Target;

/**
 * @author Kevin Yen
 */

public class LiferayBuildPerformanceLogger extends DefaultLogger {

	@Override
	public void targetFinished(BuildEvent buildEvent) {
		Target target = buildEvent.getTarget();

		long currentTime = System.currentTimeMillis();
		long startTime = _startTimes.get(target);

		StringBuilder sb = new StringBuilder();

		sb.append(currentTime);
		sb.append(" [LiferayBuildPerformanceLogger] Finished target ");
		sb.append(target.getName());
		sb.append(" in ");
		sb.append(currentTime - startTime);
		sb.append("ms");

		printMessage(sb.toString(), out, buildEvent.getPriority());
	}

	@Override
	public void targetStarted(BuildEvent buildEvent) {
		Target target = buildEvent.getTarget();

		long currentTime = System.currentTimeMillis();

		_startTimes.put(target, currentTime);

		StringBuilder sb = new StringBuilder();

		sb.append(currentTime);
		sb.append(" [LiferayBuildPerformanceLogger] Start target ");
		sb.append(target.getName());

		printMessage(sb.toString(), out, buildEvent.getPriority());
	}

	public LiferayBuildPerformanceLogger() {
		err = System.err;
		out = System.out;
	}

	private final Map<Target, Long> _startTimes = new HashMap<>();

}