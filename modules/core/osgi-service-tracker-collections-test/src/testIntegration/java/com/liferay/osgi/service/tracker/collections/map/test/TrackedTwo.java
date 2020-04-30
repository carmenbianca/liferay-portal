/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.service.tracker.collections.map.test;

/**
 * @author Carlos Sierra Andrés
 */
public class TrackedTwo {

	public TrackedTwo(TrackedOne trackedOne) {
		_trackedOne = trackedOne;
	}

	public TrackedOne getTrackedOne() {
		return _trackedOne;
	}

	private final TrackedOne _trackedOne;

}