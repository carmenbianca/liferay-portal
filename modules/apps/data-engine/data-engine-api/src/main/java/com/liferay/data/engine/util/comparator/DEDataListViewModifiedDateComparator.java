/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.util.comparator;

import com.liferay.data.engine.model.DEDataListView;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Gabriel Albuquerque
 */
public class DEDataListViewModifiedDateComparator
	extends StagedModelModifiedDateComparator<DEDataListView> {

	public DEDataListViewModifiedDateComparator() {
		this(false);
	}

	public DEDataListViewModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		return "DEDataListView." + super.getOrderBy();
	}

}