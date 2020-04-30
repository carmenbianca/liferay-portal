/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.external.model;

/**
 * @author Iván Zaera
 * @author Sergio González
 */
public class ExtRepositoryObjectAdapterType
	<T extends ExtRepositoryModelAdapter<?>> {

	public static final ExtRepositoryObjectAdapterType
		<ExtRepositoryFileEntryAdapter> FILE =
			new ExtRepositoryObjectAdapterType<>("FILE");

	public static final ExtRepositoryObjectAdapterType
		<ExtRepositoryFolderAdapter> FOLDER =
			new ExtRepositoryObjectAdapterType<>("FOLDER");

	public static final ExtRepositoryObjectAdapterType
		<ExtRepositoryObjectAdapter<?>> OBJECT =
			new ExtRepositoryObjectAdapterType<>("OBJECT");

	@Override
	public String toString() {
		return _name;
	}

	private ExtRepositoryObjectAdapterType(String name) {
		_name = name;
	}

	private final String _name;

}