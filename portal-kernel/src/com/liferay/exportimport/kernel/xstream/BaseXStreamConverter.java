/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.xstream;

import com.liferay.portal.kernel.bean.BeanPropertiesUtil;

import java.util.List;

/**
 * @author Akos Thurzo
 */
public abstract class BaseXStreamConverter implements XStreamConverter {

	@Override
	public abstract boolean canConvert(Class<?> clazz);

	@Override
	public void marshal(
			Object object, XStreamHierarchicalStreamWriter writer,
			XStreamMarshallingContext xStreamMarshallingContext)
		throws Exception {

		for (String field : getFields()) {
			writer.startNode(field);

			Object value = BeanPropertiesUtil.getObject(object, field);

			if (value != null) {
				xStreamMarshallingContext.convertAnother(value);
			}

			writer.endNode();
		}
	}

	@Override
	public abstract Object unmarshal(
			XStreamHierarchicalStreamReader xStreamHierarchicalStreamReader,
			XStreamUnmarshallingContext xStreamUnmarshallingContext)
		throws Exception;

	protected abstract List<String> getFields();

}