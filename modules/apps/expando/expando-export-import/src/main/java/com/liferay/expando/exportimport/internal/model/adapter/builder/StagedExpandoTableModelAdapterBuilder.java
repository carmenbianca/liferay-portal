/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.exportimport.internal.model.adapter.builder;

import com.liferay.expando.exportimport.internal.model.adapter.StagedExpandoTableImpl;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.adapter.StagedExpandoTable;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelAdapterBuilder.class)
public class StagedExpandoTableModelAdapterBuilder
	implements ModelAdapterBuilder<ExpandoTable, StagedExpandoTable> {

	@Override
	public StagedExpandoTable build(ExpandoTable expandoTable) {
		return new StagedExpandoTableImpl(expandoTable);
	}

}