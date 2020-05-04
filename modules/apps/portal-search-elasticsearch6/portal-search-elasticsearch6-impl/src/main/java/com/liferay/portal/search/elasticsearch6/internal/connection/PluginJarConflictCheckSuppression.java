/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.connection;

import java.util.function.Supplier;

/**
 * @author André de Oliveira
 */
public class PluginJarConflictCheckSuppression {

	public static void execute(Runnable runnable) {
		execute(
			() -> {
				runnable.run();

				return null;
			});
	}

	public static <T> T execute(Supplier<T> supplier) {
		String javaClassPath = System.getProperty("java.class.path");

		System.setProperty("java.class.path", System.getProperty("java.home"));

		try {
			return supplier.get();
		}
		finally {
			System.setProperty("java.class.path", javaClassPath);
		}
	}

}