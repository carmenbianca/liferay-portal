/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.diff;

import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class DiffVersionsInfo {

	public DiffVersionsInfo(
		List<DiffVersion> diffVersions, double nextVersion,
		double previousVersion) {

		_diffVersions = diffVersions;
		_nextVersion = nextVersion;
		_previousVersion = previousVersion;
	}

	public List<DiffVersion> getDiffVersions() {
		return _diffVersions;
	}

	public double getNextVersion() {
		return _nextVersion;
	}

	public double getPreviousVersion() {
		return _previousVersion;
	}

	public void setDiffVersions(List<DiffVersion> diffVersions) {
		_diffVersions = diffVersions;
	}

	public void setNextVersion(double nextVersion) {
		_nextVersion = nextVersion;
	}

	public void setPreviousVersion(double previousVersion) {
		_previousVersion = previousVersion;
	}

	private List<DiffVersion> _diffVersions;
	private double _nextVersion;
	private double _previousVersion;

}