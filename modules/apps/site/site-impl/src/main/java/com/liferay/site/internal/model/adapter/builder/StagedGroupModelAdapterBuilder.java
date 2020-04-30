/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.internal.model.adapter.builder;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;
import com.liferay.site.internal.model.adapter.StagedGroupImpl;
import com.liferay.site.model.adapter.StagedGroup;

import org.osgi.service.component.annotations.Component;

/**
 * @author Máté Thurzó
 */
@Component(immediate = true, service = ModelAdapterBuilder.class)
public class StagedGroupModelAdapterBuilder
	implements ModelAdapterBuilder<Group, StagedGroup> {

	@Override
	public StagedGroup build(Group group) {
		return new StagedGroupImpl(group);
	}

}