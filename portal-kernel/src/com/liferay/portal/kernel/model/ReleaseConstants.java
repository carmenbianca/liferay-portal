/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.petra.string.StringBundler;

/**
 * @author Alexander Chow
 */
public class ReleaseConstants {

	public static final long DEFAULT_ID = 1;

	public static final String DEFAULT_SERVLET_CONTEXT_NAME = "portal";

	public static final int STATE_GOOD = 0;

	public static final int STATE_UPGRADE_FAILURE = 1;

	public static final int STATE_VERIFY_FAILURE = 2;

	public static final String TEST_STRING = StringBundler.concat(
		"You take the blue pill, the story ends, you wake up in your bed and ",
		"believe whatever you want to believe. You take the red pill, you ",
		"stay in Wonderland, and I show you how deep the rabbit hole goes.");

}