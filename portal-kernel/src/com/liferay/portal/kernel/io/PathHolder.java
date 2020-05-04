/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.io;

import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;
import java.io.Serializable;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Objects;

/**
 * @author Shuyang Zhou
 */
public class PathHolder implements Serializable {

	public PathHolder(Path path) {
		this(path.toString());
	}

	public PathHolder(String pathString) {
		_pathString = pathString;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PathHolder)) {
			return false;
		}

		PathHolder pathHolder = (PathHolder)obj;

		if (Objects.equals(toString(), pathHolder.toString())) {
			return true;
		}

		return false;
	}

	public Path getPath() {
		return Paths.get(toString());
	}

	@Override
	public int hashCode() {
		String toString = toString();

		return toString.hashCode();
	}

	@Override
	public String toString() {
		if (_toString != null) {
			return _toString;
		}

		if (_separatorChar == File.separatorChar) {
			_toString = _pathString;
		}
		else {
			_toString = StringUtil.replace(
				_pathString, _separatorChar, File.separatorChar);
		}

		return _toString;
	}

	private static final long serialVersionUID = 1L;

	private final String _pathString;
	private final char _separatorChar = File.separatorChar;
	private transient String _toString;

}