/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.content.targeting.upgrade.internal.v1_0_0.util;

import com.liferay.segments.criteria.Criteria;

/**
 * @author Eduardo García
 */
public interface RuleConverter {

	public void convert(long companyId, Criteria criteria, String typeSettings);

}