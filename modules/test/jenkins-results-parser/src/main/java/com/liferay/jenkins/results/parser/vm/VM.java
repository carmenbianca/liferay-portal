/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.vm;

/**
 * @author Peter Yoo
 */
public abstract class VM {

	public abstract void create();

	public abstract void delete();

	protected static final long MILLIS_TIMEOUT_DURATION = 1000 * 60 * 10;

}