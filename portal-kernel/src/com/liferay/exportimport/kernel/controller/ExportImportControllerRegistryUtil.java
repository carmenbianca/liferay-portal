/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.controller;

import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceReference;
import com.liferay.registry.ServiceRegistration;
import com.liferay.registry.ServiceTracker;
import com.liferay.registry.ServiceTrackerCustomizer;
import com.liferay.registry.collections.ServiceRegistrationMap;
import com.liferay.registry.collections.ServiceRegistrationMapImpl;
import com.liferay.registry.util.StringPlus;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Daniel Kocsis
 */
public class ExportImportControllerRegistryUtil {

	public static ExportController getExportController(String className) {
		return _exportImportControllerRegistryUtil._getExportController(
			className);
	}

	public static List<ExportImportController> getExportImportControllers() {
		return _exportImportControllerRegistryUtil.
			_getExportImportControllers();
	}

	public static ImportController getImportController(String className) {
		return _exportImportControllerRegistryUtil._getImportController(
			className);
	}

	public static void register(ExportImportController exportImportController) {
		_exportImportControllerRegistryUtil._register(exportImportController);
	}

	public static void unregister(
		ExportImportController exportImportController) {

		_exportImportControllerRegistryUtil._unregister(exportImportController);
	}

	private ExportImportControllerRegistryUtil() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(
			ExportImportController.class,
			new ExportImportControllerServiceTrackerCustomizer());

		_serviceTracker.open();
	}

	private ExportController _getExportController(String className) {
		return _exportControllers.get(className);
	}

	private List<ExportImportController> _getExportImportControllers() {
		Collection<ExportImportController> values =
			_exportImportControllers.values();

		return ListUtil.fromCollection(values);
	}

	private ImportController _getImportController(String className) {
		return _importControllers.get(className);
	}

	private void _register(ExportImportController exportImportController) {
		Registry registry = RegistryUtil.getRegistry();

		ServiceRegistration<ExportImportController> serviceRegistration =
			registry.registerService(
				ExportImportController.class, exportImportController);

		_serviceRegistrations.put(exportImportController, serviceRegistration);
	}

	private void _unregister(ExportImportController exportImportController) {
		ServiceRegistration<ExportImportController> serviceRegistration =
			_serviceRegistrations.remove(exportImportController);

		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}
	}

	private static final ExportImportControllerRegistryUtil
		_exportImportControllerRegistryUtil =
			new ExportImportControllerRegistryUtil();

	private final Map<String, ExportController> _exportControllers =
		new ConcurrentHashMap<>();
	private final Map<String, ExportImportController> _exportImportControllers =
		new ConcurrentHashMap<>();
	private final Map<String, ImportController> _importControllers =
		new ConcurrentHashMap<>();
	private final ServiceRegistrationMap<ExportImportController>
		_serviceRegistrations = new ServiceRegistrationMapImpl<>();
	private final ServiceTracker<ExportImportController, ExportImportController>
		_serviceTracker;

	private class ExportImportControllerServiceTrackerCustomizer
		implements ServiceTrackerCustomizer
			<ExportImportController, ExportImportController> {

		@Override
		public ExportImportController addingService(
			ServiceReference<ExportImportController> serviceReference) {

			Registry registry = RegistryUtil.getRegistry();

			ExportImportController exportImportController = registry.getService(
				serviceReference);

			List<String> modelClassNames = StringPlus.asList(
				serviceReference.getProperty("model.class.name"));

			for (String modelClassName : modelClassNames) {
				if (exportImportController instanceof ExportController) {
					_exportControllers.put(
						modelClassName,
						(ExportController)exportImportController);
				}
				else if (exportImportController instanceof ImportController) {
					_importControllers.put(
						modelClassName,
						(ImportController)exportImportController);
				}

				_exportImportControllers.put(
					modelClassName, exportImportController);
			}

			return exportImportController;
		}

		@Override
		public void modifiedService(
			ServiceReference<ExportImportController> serviceReference,
			ExportImportController stagedModelDataHandler) {
		}

		@Override
		public void removedService(
			ServiceReference<ExportImportController> serviceReference,
			ExportImportController exportImportController) {

			Registry registry = RegistryUtil.getRegistry();

			registry.ungetService(serviceReference);

			List<String> modelClassNames = StringPlus.asList(
				serviceReference.getProperty("model.class.name"));

			for (String modelClassName : modelClassNames) {
				if (exportImportController instanceof ExportController) {
					_exportControllers.remove(modelClassName);
				}
				else if (exportImportController instanceof ImportController) {
					_importControllers.remove(modelClassName);
				}

				_exportImportControllers.remove(modelClassName);
			}
		}

	}

}