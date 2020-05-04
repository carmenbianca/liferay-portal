/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.support.tomcat.util.scan;

import javax.servlet.ServletContext;

import org.apache.tomcat.JarScanFilter;
import org.apache.tomcat.JarScanType;
import org.apache.tomcat.JarScanner;
import org.apache.tomcat.JarScannerCallback;

/**
 * @author Preston Crary
 */
public class NOPJarScanner implements JarScanner {

	@Override
	public JarScanFilter getJarScanFilter() {
		return _jarScanFilter;
	}

	@Override
	public void scan(
		JarScanType jarScanType, ServletContext servletContext,
		JarScannerCallback jarScannerCallback) {
	}

	@Override
	public void setJarScanFilter(JarScanFilter jarScanFilter) {
	}

	private static final JarScanFilter _jarScanFilter = new NOPJarScanFilter();

	private static class NOPJarScanFilter implements JarScanFilter {

		@Override
		public boolean check(JarScanType jarScanType, String jarName) {
			return false;
		}

	}

}