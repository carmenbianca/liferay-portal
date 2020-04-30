/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.image;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author Ivica Cardic
 */
public class GhostscriptUtil {

	public static Future<?> execute(List<String> arguments) throws Exception {
		return getGhostscript().execute(arguments);
	}

	public static Ghostscript getGhostscript() {
		return _ghostscript;
	}

	public static boolean isEnabled() {
		return getGhostscript().isEnabled();
	}

	public static void reset() {
		getGhostscript().reset();
	}

	public void setGhostscript(Ghostscript ghostscript) {
		_ghostscript = ghostscript;
	}

	private static Ghostscript _ghostscript;

}