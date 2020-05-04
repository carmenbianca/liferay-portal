/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service.http;

import com.liferay.dynamic.data.mapping.service.DDMStructureVersionServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>DDMStructureVersionServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.dynamic.data.mapping.model.DDMStructureVersionSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.dynamic.data.mapping.model.DDMStructureVersion</code>, that is translated to a
 * <code>com.liferay.dynamic.data.mapping.model.DDMStructureVersionSoap</code>. Methods that SOAP
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
 * @see DDMStructureVersionServiceHttp
 * @generated
 */
public class DDMStructureVersionServiceSoap {

	public static com.liferay.dynamic.data.mapping.model.DDMStructureVersionSoap
			getLatestStructureVersion(long structureId)
		throws RemoteException {

		try {
			com.liferay.dynamic.data.mapping.model.DDMStructureVersion
				returnValue =
					DDMStructureVersionServiceUtil.getLatestStructureVersion(
						structureId);

			return com.liferay.dynamic.data.mapping.model.
				DDMStructureVersionSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.dynamic.data.mapping.model.DDMStructureVersionSoap
			getStructureVersion(long structureVersionId)
		throws RemoteException {

		try {
			com.liferay.dynamic.data.mapping.model.DDMStructureVersion
				returnValue =
					DDMStructureVersionServiceUtil.getStructureVersion(
						structureVersionId);

			return com.liferay.dynamic.data.mapping.model.
				DDMStructureVersionSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static
		com.liferay.dynamic.data.mapping.model.DDMStructureVersionSoap[]
				getStructureVersions(
					long structureId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.liferay.dynamic.data.mapping.model.
							DDMStructureVersion> orderByComparator)
			throws RemoteException {

		try {
			java.util.List
				<com.liferay.dynamic.data.mapping.model.DDMStructureVersion>
					returnValue =
						DDMStructureVersionServiceUtil.getStructureVersions(
							structureId, start, end, orderByComparator);

			return com.liferay.dynamic.data.mapping.model.
				DDMStructureVersionSoap.toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getStructureVersionsCount(long structureId)
		throws RemoteException {

		try {
			int returnValue =
				DDMStructureVersionServiceUtil.getStructureVersionsCount(
					structureId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DDMStructureVersionServiceSoap.class);

}