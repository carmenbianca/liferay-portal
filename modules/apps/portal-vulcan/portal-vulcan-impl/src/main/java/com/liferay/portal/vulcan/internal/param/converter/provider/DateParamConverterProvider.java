/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.param.converter.provider;

import com.liferay.portal.vulcan.internal.param.converter.DateParamConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import java.util.Date;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 * @author Ivica Cardic
 */
@Provider
public class DateParamConverterProvider implements ParamConverterProvider {

	@Override
	@SuppressWarnings("unchecked")
	public <T> ParamConverter<T> getConverter(
		Class<T> clazz, Type genericType, Annotation[] annotations) {

		if (Date.class.equals(clazz)) {
			return (ParamConverter<T>)new DateParamConverter();
		}

		return null;
	}

}