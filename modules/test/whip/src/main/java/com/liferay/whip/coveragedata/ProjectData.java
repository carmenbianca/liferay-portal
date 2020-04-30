/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.whip.coveragedata;

/**
 * @author Shuyang Zhou
 */
public class ProjectData
	extends CoverageDataContainer<String, ClassData, ProjectData> {

	public ClassData getClassData(String className) {
		ClassData classData = children.get(className);

		if (classData == null) {
			throw new IllegalStateException(
				"No instrument data for class " + className);
		}

		return classData;
	}

	public ClassData getOrCreateClassData(String className) {
		ClassData classData = children.get(className);

		if (classData == null) {
			classData = new ClassData(className);

			ClassData previousClassData = children.putIfAbsent(
				className, classData);

			if (previousClassData != null) {
				classData = previousClassData;
			}
		}

		return classData;
	}

	private static final long serialVersionUID = 1;

}