/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util.comparator;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Rafael Praxedes
 */
public class DDMFormInstanceModifiedDateComparator
	extends StagedModelModifiedDateComparator<DDMFormInstance> {

	public DDMFormInstanceModifiedDateComparator() {
		this(false);
	}

	public DDMFormInstanceModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		return "DDMFormInstance." + super.getOrderBy();
	}

}