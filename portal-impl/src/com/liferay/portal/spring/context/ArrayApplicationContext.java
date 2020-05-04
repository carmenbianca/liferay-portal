/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.context;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.spring.bean.LiferayBeanFactory;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Brian Wing Shun Chan
 */
public class ArrayApplicationContext extends ClassPathXmlApplicationContext {

	public ArrayApplicationContext(String[] configLocations) {
		super(configLocations);
	}

	@Override
	protected DefaultListableBeanFactory createBeanFactory() {
		return new LiferayBeanFactory(getInternalParentBeanFactory());
	}

	@Override
	protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) {
		String[] configLocations = getConfigLocations();

		if (configLocations == null) {
			return;
		}

		for (String configLocation : configLocations) {
			try {
				reader.loadBeanDefinitions(configLocation);
			}
			catch (Exception exception) {
				Throwable cause = exception.getCause();

				if (cause instanceof FileNotFoundException) {
					if (_log.isWarnEnabled()) {
						_log.warn(cause.getMessage());
					}
				}
				else {
					_log.error(exception, exception);
				}
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ArrayApplicationContext.class);

}