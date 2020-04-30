/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.open.graph;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;

/**
 * @author Adolfo Pérez
 */
public interface OpenGraphConfiguration {

	public boolean isOpenGraphEnabled(Company company) throws PortalException;

	public boolean isOpenGraphEnabled(Group group) throws PortalException;

}