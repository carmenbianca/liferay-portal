/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Country service. Represents a row in the &quot;Country&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CountryModel
 * @generated
 */
@ImplementationClassName("com.liferay.portal.model.impl.CountryImpl")
@ProviderType
public interface Country extends CountryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.model.impl.CountryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Country, Long> COUNTRY_ID_ACCESSOR =
		new Accessor<Country, Long>() {

			@Override
			public Long get(Country country) {
				return country.getCountryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Country> getTypeClass() {
				return Country.class;
			}

		};

	public String getName(java.util.Locale locale);

	public String getNameCurrentLanguageId();

	@com.liferay.portal.kernel.json.JSON
	public String getNameCurrentValue();

	public void setNameCurrentLanguageId(String languageId);

}