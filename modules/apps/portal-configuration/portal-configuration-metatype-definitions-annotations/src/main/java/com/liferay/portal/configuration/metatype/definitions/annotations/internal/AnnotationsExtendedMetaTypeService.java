/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.metatype.definitions.annotations.internal;

import com.liferay.portal.configuration.metatype.definitions.ExtendedMetaTypeInformation;
import com.liferay.portal.configuration.metatype.definitions.ExtendedMetaTypeService;

import org.osgi.framework.Bundle;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.MetaTypeService;

/**
 * @author Iván Zaera
 */
@Component(service = ExtendedMetaTypeService.class)
public class AnnotationsExtendedMetaTypeService
	implements ExtendedMetaTypeService {

	@Override
	public ExtendedMetaTypeInformation getMetaTypeInformation(Bundle bundle) {
		return new AnnotationsExtendedMetaTypeInformation(
			bundle, _metaTypeService.getMetaTypeInformation(bundle));
	}

	@Reference(unbind = "-")
	protected void setMetaTypeService(MetaTypeService metaTypeService) {
		_metaTypeService = metaTypeService;
	}

	private MetaTypeService _metaTypeService;

}