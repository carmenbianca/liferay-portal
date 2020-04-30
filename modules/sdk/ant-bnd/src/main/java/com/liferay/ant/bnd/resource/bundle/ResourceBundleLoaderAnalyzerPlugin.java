/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ant.bnd.resource.bundle;

import aQute.bnd.osgi.Analyzer;
import aQute.bnd.service.AnalyzerPlugin;

/**
 * @author Carlos Sierra Andrés
 * @author Gregory Amerson
 */
public class ResourceBundleLoaderAnalyzerPlugin implements AnalyzerPlugin {

	@Override
	public boolean analyzeJar(Analyzer analyzer) throws Exception {
		boolean modified = false;

		for (AnalyzerPlugin analyzerPlugin : _analyzerPlugins) {
			if (analyzerPlugin.analyzeJar(analyzer)) {
				modified = true;
			}
		}

		return modified;
	}

	protected static final String LIFERAY_RESOURCE_BUNDLE =
		"liferay.resource.bundle";

	private final AnalyzerPlugin[] _analyzerPlugins = {
		new AggregateResourceBundleLoaderAnalyzerPlugin(),
		new ProvidesResourceBundleLoaderAnalyzerPlugin()
	};

}