/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.soy.builder.internal;

import com.beust.jcommander.Parameter;

/**
 * @author Gregory Amerson
 */
public class SoyBuilderArgs {

	public boolean isHelp() {
		return _help;
	}

	@Parameter(
		description = "Print this message.", help = true,
		names = {"-h", "--help"}
	)
	private boolean _help;

}