/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.io;

import com.liferay.dynamic.data.mapping.io.DDMFormLayoutDeserializer;
import com.liferay.dynamic.data.mapping.io.DDMFormLayoutDeserializerTracker;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author     Leonardo Barros
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Component(service = DDMFormLayoutDeserializerTracker.class)
@Deprecated
public class DDMFormLayoutDeserializerTrackerImpl
	implements DDMFormLayoutDeserializerTracker {

	@Override
	public DDMFormLayoutDeserializer getDDMFormLayoutDeserializer(String type) {
		if (Objects.equals(type, "json")) {
			return _jsonDDMFormLayoutDeserializer;
		}

		return null;
	}

	@Reference(target = "(ddm.form.layout.deserializer.type=json)")
	private DDMFormLayoutDeserializer _jsonDDMFormLayoutDeserializer;

}