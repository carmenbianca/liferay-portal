/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.registrar.contributor;

import com.liferay.portal.search.spi.model.registrar.ModelSearchDefinition;

/**
 * @author André de Oliveira
 */
@FunctionalInterface
public interface ModelSearchDefinitionContributor {

	public void contribute(ModelSearchDefinition modelSearchDefinition);

}