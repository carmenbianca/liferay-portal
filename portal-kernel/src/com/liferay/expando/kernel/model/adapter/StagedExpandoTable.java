/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.model.adapter;

import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.portal.kernel.model.StagedModel;

/**
 * @author Akos Thurzo
 */
public interface StagedExpandoTable extends ExpandoTable, StagedModel {
}