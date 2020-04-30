/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

/**
 * @author Hugo Huijser
 */
public class ProgressStatusUpdate {

	public ProgressStatusUpdate(ProgressStatus progressStatus) {
		_progressStatus = progressStatus;
	}

	public ProgressStatusUpdate(ProgressStatus progressStatus, int count) {
		_progressStatus = progressStatus;
		_count = count;
	}

	public int getCount() {
		return _count;
	}

	public ProgressStatus getProgressStatus() {
		return _progressStatus;
	}

	private int _count;
	private final ProgressStatus _progressStatus;

}