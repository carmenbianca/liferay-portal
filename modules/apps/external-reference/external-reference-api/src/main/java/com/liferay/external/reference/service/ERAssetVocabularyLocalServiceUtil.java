/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.reference.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ERAssetVocabulary. This utility wraps
 * <code>com.liferay.external.reference.service.impl.ERAssetVocabularyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ERAssetVocabularyLocalService
 * @generated
 */
public class ERAssetVocabularyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.external.reference.service.impl.ERAssetVocabularyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.asset.kernel.model.AssetVocabulary
			addOrUpdateVocabulary(
				String externalReferenceCode, long userId, long groupId,
				String title, java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String settings,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addOrUpdateVocabulary(
			externalReferenceCode, userId, groupId, title, titleMap,
			descriptionMap, settings, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ERAssetVocabularyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ERAssetVocabularyLocalService, ERAssetVocabularyLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ERAssetVocabularyLocalService.class);

		ServiceTracker
			<ERAssetVocabularyLocalService, ERAssetVocabularyLocalService>
				serviceTracker =
					new ServiceTracker
						<ERAssetVocabularyLocalService,
						 ERAssetVocabularyLocalService>(
							 bundle.getBundleContext(),
							 ERAssetVocabularyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}