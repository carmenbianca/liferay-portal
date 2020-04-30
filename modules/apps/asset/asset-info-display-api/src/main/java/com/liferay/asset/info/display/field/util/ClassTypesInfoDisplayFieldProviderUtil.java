/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.info.display.field.util;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.ClassType;
import com.liferay.asset.kernel.model.ClassTypeReader;
import com.liferay.info.display.contributor.InfoDisplayField;
import com.liferay.info.display.field.ClassTypesInfoDisplayFieldProvider;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;
import java.util.Locale;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Jürgen Kappler
 */
public class ClassTypesInfoDisplayFieldProviderUtil {

	public static List<InfoDisplayField> getClassTypeInfoDisplayFields(
			String className, long classTypeId, Locale locale)
		throws PortalException {

		ClassTypesInfoDisplayFieldProvider classTypesInfoDisplayFieldProvider =
			_serviceTracker.getService();

		ClassTypeReader classTypeReader = _getClassTypeReader(className);

		ClassType classType = classTypeReader.getClassType(classTypeId, locale);

		return classTypesInfoDisplayFieldProvider.getClassTypeInfoDisplayFields(
			classType, locale);
	}

	public static List<ClassType> getClassTypes(
			long groupId, String className, Locale locale)
		throws PortalException {

		ClassTypesInfoDisplayFieldProvider classTypesInfoDisplayFieldProvider =
			_serviceTracker.getService();

		ClassTypeReader classTypeReader = _getClassTypeReader(className);

		return classTypesInfoDisplayFieldProvider.getClassTypes(
			groupId, classTypeReader, locale);
	}

	private static ClassTypeReader _getClassTypeReader(String className) {
		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				className);

		if ((assetRendererFactory == null) ||
			!assetRendererFactory.isSupportsClassTypes()) {

			return null;
		}

		return assetRendererFactory.getClassTypeReader();
	}

	private static final ServiceTracker
		<ClassTypesInfoDisplayFieldProvider, ClassTypesInfoDisplayFieldProvider>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ClassTypesInfoDisplayFieldProviderUtil.class);

		ServiceTracker
			<ClassTypesInfoDisplayFieldProvider,
			 ClassTypesInfoDisplayFieldProvider> serviceTracker =
				new ServiceTracker<>(
					bundle.getBundleContext(),
					ClassTypesInfoDisplayFieldProvider.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}