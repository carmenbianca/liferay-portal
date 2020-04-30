/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.index;

import java.util.Collection;

/**
 * @author André de Oliveira
 */
public interface IndexDefinitionsHolder {

	public void drainTo(Collection<IndexDefinitionData> collection);

}