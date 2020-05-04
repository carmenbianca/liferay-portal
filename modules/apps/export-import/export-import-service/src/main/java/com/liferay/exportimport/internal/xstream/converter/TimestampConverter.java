/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.xstream.converter;

import com.liferay.exportimport.kernel.xstream.BaseXStreamConverter;
import com.liferay.exportimport.kernel.xstream.XStreamHierarchicalStreamReader;
import com.liferay.exportimport.kernel.xstream.XStreamHierarchicalStreamWriter;
import com.liferay.exportimport.kernel.xstream.XStreamMarshallingContext;
import com.liferay.exportimport.kernel.xstream.XStreamUnmarshallingContext;

import com.thoughtworks.xstream.converters.extended.SqlTimestampConverter;

import java.sql.Timestamp;

import java.util.List;

/**
 * @author Rodrigo Paulino
 */
public class TimestampConverter extends BaseXStreamConverter {

	public TimestampConverter() {
		_converter = new SqlTimestampConverter();
	}

	@Override
	public boolean canConvert(Class<?> clazz) {
		Class<?> superClass = clazz.getSuperclass();

		if (clazz.equals(Timestamp.class) ||
			((superClass != null) && superClass.equals(Timestamp.class))) {

			return true;
		}

		return false;
	}

	@Override
	public void marshal(
			Object object, XStreamHierarchicalStreamWriter writer,
			XStreamMarshallingContext xStreamMarshallingContext)
		throws Exception {

		writer.setValue(_converter.toString(object));
	}

	@Override
	public Object unmarshal(
			XStreamHierarchicalStreamReader xStreamHierarchicalStreamReader,
			XStreamUnmarshallingContext xStreamUnmarshallingContext)
		throws Exception {

		return _converter.fromString(
			xStreamHierarchicalStreamReader.getValue());
	}

	@Override
	protected List<String> getFields() {
		return null;
	}

	private final SqlTimestampConverter _converter;

}