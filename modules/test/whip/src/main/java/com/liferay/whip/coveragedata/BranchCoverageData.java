/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.whip.coveragedata;

/**
 * @author Shuyang Zhou
 */
public interface BranchCoverageData<T extends BranchCoverageData<T>> {

	public double getBranchCoverageRate();

	public int getNumberOfCoveredBranches();

	public int getNumberOfValidBranches();

	public void merge(T t);

}