/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util.comparator;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Leonardo Barros
 */
public class DDMFormInstanceRecordModifiedDateComparator
	extends StagedModelModifiedDateComparator<DDMFormInstanceRecord> {

	public DDMFormInstanceRecordModifiedDateComparator() {
		this(false);
	}

	public DDMFormInstanceRecordModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		return "DDMFormInstanceRecord." + super.getOrderBy();
	}

}