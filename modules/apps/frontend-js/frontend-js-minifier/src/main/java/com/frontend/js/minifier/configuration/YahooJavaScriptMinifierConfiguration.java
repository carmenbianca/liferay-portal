/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.frontend.js.minifier.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Iván Zaera Avellón
 */
@Meta.OCD(
	id = "com.frontend.js.minifier.configuration.YahooJavaScriptMinifierConfiguration",
	localization = "content/Language", name = "yahoo-js-minifier-configuration"
)
public interface YahooJavaScriptMinifierConfiguration {

	@Meta.AD(deflt = "1", name = "css-line-break", required = false)
	public int cssLineBreak();

	@Meta.AD(
		deflt = "false", name = "js-disable-optimizations", required = false
	)
	public boolean jsDisableOptimizations();

	@Meta.AD(deflt = "1", name = "js-line-break", required = false)
	public int jsLineBreak();

	@Meta.AD(deflt = "true", name = "js-munge", required = false)
	public boolean jsMunge();

	@Meta.AD(
		deflt = "false", name = "js-preserve-all-semicolons", required = false
	)
	public boolean jsPreserveAllSemicolons();

	@Meta.AD(deflt = "false", name = "js-verbose", required = false)
	public boolean jsVerbose();

}