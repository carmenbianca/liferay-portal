/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.layout.prototype;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;

/**
 * @author André de Oliveira
 */
public interface SearchLayoutFactory {

	public void createSearchLayout(Group group);

	public void createSearchLayoutPrototype(Company company);

}