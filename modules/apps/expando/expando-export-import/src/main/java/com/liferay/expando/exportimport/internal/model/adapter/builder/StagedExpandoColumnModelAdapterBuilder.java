/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.exportimport.internal.model.adapter.builder;

import com.liferay.expando.exportimport.internal.model.adapter.StagedExpandoColumnImpl;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.adapter.StagedExpandoColumn;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelAdapterBuilder.class)
public class StagedExpandoColumnModelAdapterBuilder
	implements ModelAdapterBuilder<ExpandoColumn, StagedExpandoColumn> {

	@Override
	public StagedExpandoColumn build(ExpandoColumn expandoColumn) {
		return new StagedExpandoColumnImpl(expandoColumn);
	}

}