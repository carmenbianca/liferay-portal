/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for Country. This utility wraps
 * <code>com.liferay.portal.service.impl.CountryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CountryService
 * @generated
 */
public class CountryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.CountryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.Country addCountry(
			String name, String a2, String a3, String number, String idd,
			boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCountry(name, a2, a3, number, idd, active);
	}

	public static com.liferay.portal.kernel.model.Country fetchCountry(
		long countryId) {

		return getService().fetchCountry(countryId);
	}

	public static com.liferay.portal.kernel.model.Country fetchCountryByA2(
		String a2) {

		return getService().fetchCountryByA2(a2);
	}

	public static com.liferay.portal.kernel.model.Country fetchCountryByA3(
		String a3) {

		return getService().fetchCountryByA3(a3);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Country>
		getCountries() {

		return getService().getCountries();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Country>
		getCountries(boolean active) {

		return getService().getCountries(active);
	}

	public static com.liferay.portal.kernel.model.Country getCountry(
			long countryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCountry(countryId);
	}

	public static com.liferay.portal.kernel.model.Country getCountryByA2(
			String a2)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCountryByA2(a2);
	}

	public static com.liferay.portal.kernel.model.Country getCountryByA3(
			String a3)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCountryByA3(a3);
	}

	public static com.liferay.portal.kernel.model.Country getCountryByName(
			String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCountryByName(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CountryService getService() {
		if (_service == null) {
			_service = (CountryService)PortalBeanLocatorUtil.locate(
				CountryService.class.getName());
		}

		return _service;
	}

	private static CountryService _service;

}