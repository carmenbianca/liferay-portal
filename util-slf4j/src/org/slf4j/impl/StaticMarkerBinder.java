/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package org.slf4j.impl;

import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.spi.MarkerFactoryBinder;

/**
 * @author Michael C. Han
 */
public class StaticMarkerBinder implements MarkerFactoryBinder {

	public static final StaticMarkerBinder SINGLETON = new StaticMarkerBinder();

	@Override
	public IMarkerFactory getMarkerFactory() {
		return _iMarkerFactory;
	}

	@Override
	public String getMarkerFactoryClassStr() {
		return BasicMarkerFactory.class.getName();
	}

	private StaticMarkerBinder() {
	}

	private final IMarkerFactory _iMarkerFactory = new BasicMarkerFactory();

}