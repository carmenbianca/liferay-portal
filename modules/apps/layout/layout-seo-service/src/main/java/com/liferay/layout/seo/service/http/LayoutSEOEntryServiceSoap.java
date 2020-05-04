/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.service.http;

import com.liferay.layout.seo.service.LayoutSEOEntryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * <code>LayoutSEOEntryServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.layout.seo.model.LayoutSEOEntrySoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.layout.seo.model.LayoutSEOEntry</code>, that is translated to a
 * <code>com.liferay.layout.seo.model.LayoutSEOEntrySoap</code>. Methods that SOAP
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
 * @see LayoutSEOEntryServiceHttp
 * @generated
 */
public class LayoutSEOEntryServiceSoap {

	public static com.liferay.layout.seo.model.LayoutSEOEntrySoap
			updateLayoutSEOEntry(
				long groupId, boolean privateLayout, long layoutId,
				boolean canonicalURLEnabled,
				String[] canonicalURLMapLanguageIds,
				String[] canonicalURLMapValues,
				boolean openGraphDescriptionEnabled,
				String[] openGraphDescriptionMapLanguageIds,
				String[] openGraphDescriptionMapValues,
				String[] openGraphImageAltMapLanguageIds,
				String[] openGraphImageAltMapValues,
				long openGraphImageFileEntryId, boolean openGraphTitleEnabled,
				String[] openGraphTitleMapLanguageIds,
				String[] openGraphTitleMapValues,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			Map<Locale, String> canonicalURLMap =
				LocalizationUtil.getLocalizationMap(
					canonicalURLMapLanguageIds, canonicalURLMapValues);
			Map<Locale, String> openGraphDescriptionMap =
				LocalizationUtil.getLocalizationMap(
					openGraphDescriptionMapLanguageIds,
					openGraphDescriptionMapValues);
			Map<Locale, String> openGraphImageAltMap =
				LocalizationUtil.getLocalizationMap(
					openGraphImageAltMapLanguageIds,
					openGraphImageAltMapValues);
			Map<Locale, String> openGraphTitleMap =
				LocalizationUtil.getLocalizationMap(
					openGraphTitleMapLanguageIds, openGraphTitleMapValues);

			com.liferay.layout.seo.model.LayoutSEOEntry returnValue =
				LayoutSEOEntryServiceUtil.updateLayoutSEOEntry(
					groupId, privateLayout, layoutId, canonicalURLEnabled,
					canonicalURLMap, openGraphDescriptionEnabled,
					openGraphDescriptionMap, openGraphImageAltMap,
					openGraphImageFileEntryId, openGraphTitleEnabled,
					openGraphTitleMap, serviceContext);

			return com.liferay.layout.seo.model.LayoutSEOEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.layout.seo.model.LayoutSEOEntrySoap
			updateLayoutSEOEntry(
				long groupId, boolean privateLayout, long layoutId,
				boolean enabledCanonicalURLMap,
				String[] canonicalURLMapLanguageIds,
				String[] canonicalURLMapValues,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			Map<Locale, String> canonicalURLMap =
				LocalizationUtil.getLocalizationMap(
					canonicalURLMapLanguageIds, canonicalURLMapValues);

			com.liferay.layout.seo.model.LayoutSEOEntry returnValue =
				LayoutSEOEntryServiceUtil.updateLayoutSEOEntry(
					groupId, privateLayout, layoutId, enabledCanonicalURLMap,
					canonicalURLMap, serviceContext);

			return com.liferay.layout.seo.model.LayoutSEOEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LayoutSEOEntryServiceSoap.class);

}