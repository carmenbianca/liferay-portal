/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.model.adapter;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.StagedModel;

/**
 * @author Daniel Kocsis
 */
public interface StagedGroup extends StagedModel {

	public Group getGroup();

}