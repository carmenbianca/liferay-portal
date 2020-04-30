/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ryan Park
 */
public class ContactsExtensionsUtil {

	public static Map<String, String> getExtensions() {
		return _contactsExtensionsUtil._getExtensions();
	}

	public static void register(String servletContextName, String path) {
		_contactsExtensionsUtil._register(servletContextName, path);
	}

	public static void unregister(String servletContextName) {
		_contactsExtensionsUtil._unregister(servletContextName);
	}

	private ContactsExtensionsUtil() {
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

	private static final ContactsExtensionsUtil _contactsExtensionsUtil =
		new ContactsExtensionsUtil();

	private final Map<String, String> _extensions;

}