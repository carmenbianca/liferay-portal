/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.spi.converter.model;

import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleActionSerializer;

/**
 * @author Marcellus Tavares
 */
public interface SPIDDMFormRuleAction extends SPIDDMFormRuleActionSerializer {

	public String getAction();

}