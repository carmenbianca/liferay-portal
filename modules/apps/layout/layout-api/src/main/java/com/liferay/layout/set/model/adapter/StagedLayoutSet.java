/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.set.model.adapter;

import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.StagedGroupedModel;

import java.util.Optional;

/**
 * @author Máté Thurzó
 */
public interface StagedLayoutSet extends StagedGroupedModel {

	public LayoutSet getLayoutSet();

	public Optional<String> getLayoutSetPrototypeName();

}