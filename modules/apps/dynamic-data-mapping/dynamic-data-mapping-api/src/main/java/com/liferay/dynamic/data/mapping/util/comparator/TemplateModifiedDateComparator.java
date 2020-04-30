/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util.comparator;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Eduardo García
 */
public class TemplateModifiedDateComparator
	extends StagedModelModifiedDateComparator<DDMTemplate> {

	public TemplateModifiedDateComparator() {
		this(false);
	}

	public TemplateModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		return "DDMTemplate." + super.getOrderBy();
	}

}