/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.bundle.builder.internal.converters;

import com.beust.jcommander.converters.IParameterSplitter;

import java.io.File;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrea Di Giorgi
 */
public class PathParameterSplitter implements IParameterSplitter {

	@Override
	public List<String> split(String value) {
		return Arrays.asList(value.split(",|" + File.pathSeparator));
	}

}