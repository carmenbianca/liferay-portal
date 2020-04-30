/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.metatype.definitions;

import org.osgi.framework.Bundle;
import org.osgi.service.metatype.MetaTypeService;

/**
 * @author Iván Zaera
 */
public interface ExtendedMetaTypeService extends MetaTypeService {

	@Override
	public ExtendedMetaTypeInformation getMetaTypeInformation(Bundle bundle);

}