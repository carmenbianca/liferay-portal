/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.model.adapter.builder;

import com.liferay.layout.internal.model.adapter.StagedLayoutSetImpl;
import com.liferay.layout.set.model.adapter.StagedLayoutSet;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Máté Thurzó
 */
@Component(immediate = true, service = ModelAdapterBuilder.class)
public class StagedLayoutSetModelAdapterBuilder
	implements ModelAdapterBuilder<LayoutSet, StagedLayoutSet> {

	@Override
	public StagedLayoutSet build(LayoutSet layoutSet) {
		return new StagedLayoutSetImpl(layoutSet);
	}

}