/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.zip;

import com.liferay.petra.reflect.ReflectionUtil;

import java.lang.reflect.Field;

/**
 * @author Shuyang Zhou
 */
public class TrueZIPHelperUtil {

	public static void initialize() {
		try {
			Class.forName(
				"de.schlichtherle.io.ArchiveControllers", true,
				TrueZIPHelperUtil.class.getClassLoader());

			Class<?> clazz = Class.forName(
				"de.schlichtherle.io.ArchiveControllers$ShutdownHook");

			Field field = ReflectionUtil.getDeclaredField(clazz, "SINGLETON");

			Thread thread = (Thread)field.get(null);

			Runtime runtime = Runtime.getRuntime();

			if (runtime.removeShutdownHook(thread)) {
				_thread = thread;
			}
		}
		catch (Exception exception) {
			ReflectionUtil.throwException(exception);
		}
	}

	public static void shutdown() {
		Thread thread = _thread;

		if (thread != null) {
			thread.start();

			try {
				thread.join();
			}
			catch (InterruptedException interruptedException) {
				ReflectionUtil.throwException(interruptedException);
			}
		}
	}

	private static volatile Thread _thread;

}