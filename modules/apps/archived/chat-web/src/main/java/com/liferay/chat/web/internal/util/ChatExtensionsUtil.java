/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.web.internal.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ryan Park
 */
public class ChatExtensionsUtil {

	public static Map<String, String> getExtensions() {
		return _chatExtensionsUtil._getExtensions();
	}

	public static void register(String servletContextName, String path) {
		_chatExtensionsUtil._register(servletContextName, path);
	}

	public static void unregister(String servletContextName) {
		_chatExtensionsUtil._unregister(servletContextName);
	}

	private ChatExtensionsUtil() {
		_extensions = new ConcurrentHashMap<>();
	}

	private Map<String, String> _getExtensions() {
		return _extensions;
	}

	private void _register(String servletContextName, String path) {
		_extensions.put(servletContextName, path);
	}

	private void _unregister(String servletContextName) {
		_extensions.remove(servletContextName);
	}

	private static final ChatExtensionsUtil _chatExtensionsUtil =
		new ChatExtensionsUtil();

	private final Map<String, String> _extensions;

}