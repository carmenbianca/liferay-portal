/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.util.comparator;

import com.liferay.app.builder.model.AppBuilderApp;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Gabriel Albuquerque
 */
public class AppBuilderAppModifiedDateComparator
	extends StagedModelModifiedDateComparator<AppBuilderApp> {

	public AppBuilderAppModifiedDateComparator() {
		this(false);
	}

	public AppBuilderAppModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		return "AppBuilderApp." + super.getOrderBy();
	}

}