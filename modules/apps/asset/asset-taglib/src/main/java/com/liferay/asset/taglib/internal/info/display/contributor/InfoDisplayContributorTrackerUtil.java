/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.taglib.internal.info.display.contributor;

import com.liferay.info.display.contributor.InfoDisplayContributorTracker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(immediate = true, service = {})
public class InfoDisplayContributorTrackerUtil {

	public static final InfoDisplayContributorTracker
		getInfoDisplayContributorTracker() {

		return _infoDisplayContributorTracker;
	}

	@Reference(unbind = "-")
	protected void setServletContext(
		InfoDisplayContributorTracker infoDisplayContributorTracker) {

		_infoDisplayContributorTracker = infoDisplayContributorTracker;
	}

	private static InfoDisplayContributorTracker _infoDisplayContributorTracker;

}