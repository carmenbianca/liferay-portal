/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.resource;

import com.liferay.portal.odata.entity.EntityModel;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Brian Wing Shun Chan
 */
public interface EntityModelResource {

	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
		throws Exception;

}