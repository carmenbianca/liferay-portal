/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.content.page.editor.web.internal.util;

import com.liferay.info.display.contributor.InfoDisplayContributor;
import com.liferay.info.display.contributor.InfoDisplayContributorTracker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(service = {})
public class InfoDisplayContributorTrackerUtil {

	public static InfoDisplayContributor getInfoDisplayContributor(
		String className) {

		return _infoDisplayContributorTracker.getInfoDisplayContributor(
			className);
	}

	@Reference(unbind = "-")
	protected void setsInfoDisplayContributorTracker(
		InfoDisplayContributorTracker infoDisplayContributorTracker) {

		_infoDisplayContributorTracker = infoDisplayContributorTracker;
	}

	private static InfoDisplayContributorTracker _infoDisplayContributorTracker;

}