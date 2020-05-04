/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.io;

import com.liferay.dynamic.data.mapping.io.DDMFormLayoutSerializer;
import com.liferay.dynamic.data.mapping.io.DDMFormLayoutSerializerTracker;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author     Leonardo Barros
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Component(service = DDMFormLayoutSerializerTracker.class)
@Deprecated
public class DDMFormLayoutSerializerTrackerImpl
	implements DDMFormLayoutSerializerTracker {

	@Override
	public DDMFormLayoutSerializer getDDMFormLayoutSerializer(String type) {
		if (Objects.equals(type, "json")) {
			return _jsonDDMFormLayoutSerializer;
		}

		return null;
	}

	@Reference(target = "(ddm.form.layout.serializer.type=json)")
	private DDMFormLayoutSerializer _jsonDDMFormLayoutSerializer;

}