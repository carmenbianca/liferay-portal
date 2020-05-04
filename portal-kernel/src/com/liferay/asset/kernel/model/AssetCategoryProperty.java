/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AssetCategoryProperty service. Represents a row in the &quot;AssetCategoryProperty&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AssetCategoryPropertyModel
 * @deprecated
 * @generated
 */
@Deprecated
@ImplementationClassName(
	"com.liferay.portlet.asset.model.impl.AssetCategoryPropertyImpl"
)
@ProviderType
public interface AssetCategoryProperty
	extends AssetCategoryPropertyModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portlet.asset.model.impl.AssetCategoryPropertyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AssetCategoryProperty, Long>
		CATEGORY_PROPERTY_ID_ACCESSOR =
			new Accessor<AssetCategoryProperty, Long>() {

				@Override
				public Long get(AssetCategoryProperty assetCategoryProperty) {
					return assetCategoryProperty.getCategoryPropertyId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AssetCategoryProperty> getTypeClass() {
					return AssetCategoryProperty.class;
				}

			};

}