/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.metatype.definitions.equinox.internal;

import com.liferay.portal.configuration.metatype.definitions.ExtendedMetaTypeInformation;
import com.liferay.portal.configuration.metatype.definitions.ExtendedMetaTypeService;

import org.osgi.framework.Bundle;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.MetaTypeService;

/**
 * @author Iván Zaera
 */
public class EquinoxExtendedMetaTypeService implements ExtendedMetaTypeService {

	@Override
	public ExtendedMetaTypeInformation getMetaTypeInformation(Bundle bundle) {
		return new EquinoxExtendedMetaTypeInformation(
			_metaTypeService.getMetaTypeInformation(bundle));
	}

	@Reference(unbind = "-")
	protected void setMetaTypeService(MetaTypeService metaTypeService) {
		_metaTypeService = metaTypeService;
	}

	private MetaTypeService _metaTypeService;

}