/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.counter.service.persistence;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import java.io.Serializable;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author Patrick Brady
 */
public class IDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) {
		Class<?> clazz = object.getClass();

		String name = clazz.getName();

		int currentId = (int)CounterLocalServiceUtil.increment(name);

		return new Integer(currentId);
	}

}