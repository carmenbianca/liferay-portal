/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.pagination;

/**
 * @author Jorge Ferrer
 */
public class Pagination {

	public static Pagination of(int end, int start) {
		return new Pagination(end, start);
	}

	public int getDelta() {
		return _end - _start;
	}

	public int getEnd() {
		return _end;
	}

	public int getStart() {
		return _start;
	}

	private Pagination(int end, int start) {
		_end = end;
		_start = start;
	}

	private final int _end;
	private final int _start;

}