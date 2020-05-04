/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.io;

import com.liferay.dynamic.data.mapping.io.DDMFormFieldTypesSerializer;
import com.liferay.dynamic.data.mapping.io.DDMFormFieldTypesSerializerTracker;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author     Leonardo Barros
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Component(service = DDMFormFieldTypesSerializerTracker.class)
@Deprecated
public class DDMFormFieldTypesSerializerTrackerImpl
	implements DDMFormFieldTypesSerializerTracker {

	@Override
	public DDMFormFieldTypesSerializer getDDMFormFieldTypesSerializer(
		String type) {

		if (Objects.equals(type, "json")) {
			return _ddmFormFieldTypesSerializer;
		}

		return null;
	}

	@Reference(target = "(ddm.form.field.types.serializer.type=json)")
	private DDMFormFieldTypesSerializer _ddmFormFieldTypesSerializer;

}