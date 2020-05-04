/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model.adapter;

import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilderLocator;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Máté Thurzó
 */
public class ModelAdapterUtil {

	public static <T, V> List<V> adapt(
		List<T> adapteeModels, Class<T> adapteeModelClass,
		Class<V> adaptedModelClass) {

		List<V> adaptedModels = new ArrayList<>();

		for (T adapteeModel : adapteeModels) {
			adaptedModels.add(
				adapt(adapteeModel, adapteeModelClass, adaptedModelClass));
		}

		return adaptedModels;
	}

	public static <T, V> List<V> adapt(
		List<T> adapteeModels, Class<V> adaptedModelClass) {

		List<V> adaptedModels = new ArrayList<>();

		for (T adapteeModel : adapteeModels) {
			adaptedModels.add(adapt(adapteeModel, adaptedModelClass));
		}

		return adaptedModels;
	}

	public static <T, V> V adapt(
		T adapteeModel, Class<T> adapteeModelClass,
		Class<V> adaptedModelClass) {

		return doAdapt(adapteeModel, adapteeModelClass, adaptedModelClass);
	}

	public static <T, V> V adapt(T adapteeModel, Class<V> adaptedModelClass) {
		Class<T> adapteeModelClass = (Class<T>)adapteeModel.getClass();

		return doAdapt(adapteeModel, adapteeModelClass, adaptedModelClass);
	}

	protected static <T, V> V doAdapt(
		T adapteeModel, Class<T> adapteeModelClass,
		Class<V> adaptedModelClass) {

		ModelAdapterBuilderLocator modelAdapterBuilderLocator =
			_modelAdapterBuilderLocatorServiceTracker.getService();

		if (modelAdapterBuilderLocator == null) {
			return null;
		}

		ModelAdapterBuilder<T, V> modelAdapterBuilder =
			modelAdapterBuilderLocator.locate(
				adapteeModelClass, adaptedModelClass);

		return modelAdapterBuilder.build(adapteeModel);
	}

	private static final ServiceTracker
		<ModelAdapterBuilderLocator, ModelAdapterBuilderLocator>
			_modelAdapterBuilderLocatorServiceTracker;

	static {
		Registry registry = RegistryUtil.getRegistry();

		_modelAdapterBuilderLocatorServiceTracker = registry.trackServices(
			ModelAdapterBuilderLocator.class);

		_modelAdapterBuilderLocatorServiceTracker.open();
	}

}