/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.settings;

import com.liferay.portal.search.elasticsearch6.settings.SettingsContributor;

/**
 * @author Michael C. Han
 */
public abstract class BaseSettingsContributor implements SettingsContributor {

	public BaseSettingsContributor(int priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(SettingsContributor settingsContributor) {
		if (priority > settingsContributor.getPriority()) {
			return 1;
		}
		else if (priority == settingsContributor.getPriority()) {
			return 0;
		}

		return -1;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	protected int priority;

}