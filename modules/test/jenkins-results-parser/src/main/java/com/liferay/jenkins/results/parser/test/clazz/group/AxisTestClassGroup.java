/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

/**
 * @author Michael Hashimoto
 */
public class AxisTestClassGroup extends BaseTestClassGroup {

	public String getBatchName() {
		return _batchTestClassGroup.getBatchName();
	}

	public BatchTestClassGroup getBatchTestClassGroup() {
		return _batchTestClassGroup;
	}

	public int getId() {
		return _id;
	}

	protected AxisTestClassGroup(
		BatchTestClassGroup batchTestClassGroup, int id) {

		_batchTestClassGroup = batchTestClassGroup;
		_id = id;
	}

	private final BatchTestClassGroup _batchTestClassGroup;
	private final int _id;

}