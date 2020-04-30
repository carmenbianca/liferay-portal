/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util.comparator;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Eduardo García
 */
public class StructureModifiedDateComparator
	extends StagedModelModifiedDateComparator<DDMStructure> {

	public StructureModifiedDateComparator() {
		this(false);
	}

	public StructureModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		return "DDMStructure." + super.getOrderBy();
	}

}