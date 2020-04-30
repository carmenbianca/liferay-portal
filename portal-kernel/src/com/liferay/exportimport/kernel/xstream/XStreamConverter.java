/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.xstream;

/**
 * @author Daniel Kocsis
 */
public interface XStreamConverter {

	public boolean canConvert(Class<?> clazz);

	public void marshal(
			Object object,
			XStreamHierarchicalStreamWriter xStreamHierarchicalStreamWriter,
			XStreamMarshallingContext xStreamMarshallingContext)
		throws Exception;

	public Object unmarshal(
			XStreamHierarchicalStreamReader xStreamHierarchicalStreamReader,
			XStreamUnmarshallingContext xStreamUnmarshallingContext)
		throws Exception;

}