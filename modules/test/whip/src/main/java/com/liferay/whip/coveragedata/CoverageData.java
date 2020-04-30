/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.whip.coveragedata;

/**
 * @author Shuyang Zhou
 */
public interface CoverageData<T extends CoverageData<T>>
	extends BranchCoverageData<T> {

	public double getLineCoverageRate();

	public int getNumberOfCoveredLines();

	public int getNumberOfValidLines();

}