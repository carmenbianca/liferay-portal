/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package org.slf4j.impl;

import org.slf4j.helpers.BasicMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * @author Michael C. Han
 */
public class StaticMDCBinder {

	public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

	public MDCAdapter getMDCA() {
		return new BasicMDCAdapter();
	}

	public String getMDCAdapterClassStr() {
		return BasicMDCAdapter.class.getName();
	}

	private StaticMDCBinder() {
	}

}