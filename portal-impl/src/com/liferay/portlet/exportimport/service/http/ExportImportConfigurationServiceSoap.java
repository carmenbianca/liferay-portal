/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.exportimport.service.http;

import com.liferay.exportimport.kernel.service.ExportImportConfigurationServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ExportImportConfigurationServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.exportimport.kernel.model.ExportImportConfigurationSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.exportimport.kernel.model.ExportImportConfiguration</code>, that is translated to a
 * <code>com.liferay.exportimport.kernel.model.ExportImportConfigurationSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExportImportConfigurationServiceHttp
 * @generated
 */
public class ExportImportConfigurationServiceSoap {

	public static void deleteExportImportConfiguration(
			long exportImportConfigurationId)
		throws RemoteException {

		try {
			ExportImportConfigurationServiceUtil.
				deleteExportImportConfiguration(exportImportConfigurationId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static
		com.liferay.exportimport.kernel.model.ExportImportConfigurationSoap
				moveExportImportConfigurationToTrash(
					long exportImportConfigurationId)
			throws RemoteException {

		try {
			com.liferay.exportimport.kernel.model.ExportImportConfiguration
				returnValue =
					ExportImportConfigurationServiceUtil.
						moveExportImportConfigurationToTrash(
							exportImportConfigurationId);

			return com.liferay.exportimport.kernel.model.
				ExportImportConfigurationSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static
		com.liferay.exportimport.kernel.model.ExportImportConfigurationSoap
				restoreExportImportConfigurationFromTrash(
					long exportImportConfigurationId)
			throws RemoteException {

		try {
			com.liferay.exportimport.kernel.model.ExportImportConfiguration
				returnValue =
					ExportImportConfigurationServiceUtil.
						restoreExportImportConfigurationFromTrash(
							exportImportConfigurationId);

			return com.liferay.exportimport.kernel.model.
				ExportImportConfigurationSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ExportImportConfigurationServiceSoap.class);

}