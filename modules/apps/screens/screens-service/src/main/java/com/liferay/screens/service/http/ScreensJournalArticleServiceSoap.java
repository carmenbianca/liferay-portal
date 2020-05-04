/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.screens.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.screens.service.ScreensJournalArticleServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ScreensJournalArticleServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
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
 * @author José Manuel Navarro
 * @see ScreensJournalArticleServiceHttp
 * @generated
 */
public class ScreensJournalArticleServiceSoap {

	public static String getJournalArticleContent(long classPK, String locale)
		throws RemoteException {

		try {
			String returnValue =
				ScreensJournalArticleServiceUtil.getJournalArticleContent(
					classPK, LocaleUtil.fromLanguageId(locale));

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getJournalArticleContent(
			long classPK, long ddmTemplateId, String locale)
		throws RemoteException {

		try {
			String returnValue =
				ScreensJournalArticleServiceUtil.getJournalArticleContent(
					classPK, ddmTemplateId, LocaleUtil.fromLanguageId(locale));

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getJournalArticleContent(
			long groupId, String articleId, long ddmTemplateId, String locale)
		throws RemoteException {

		try {
			String returnValue =
				ScreensJournalArticleServiceUtil.getJournalArticleContent(
					groupId, articleId, ddmTemplateId,
					LocaleUtil.fromLanguageId(locale));

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ScreensJournalArticleServiceSoap.class);

}