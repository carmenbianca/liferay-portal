/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

/**
 * @author Adolfo Pérez
 */
public class ClassTypeField {

	public ClassTypeField(
		String label, String name, String type, long classTypeId) {

		_label = label;
		_name = name;
		_type = type;
		_classTypeId = classTypeId;
	}

	public long getClassTypeId() {
		return _classTypeId;
	}

	public String getLabel() {
		return _label;
	}

	public String getName() {
		return _name;
	}

	public String getType() {
		return _type;
	}

	private final long _classTypeId;
	private final String _label;
	private final String _name;
	private final String _type;

}