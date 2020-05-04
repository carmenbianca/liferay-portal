/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.page.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AssetDisplayPageEntry service. Represents a row in the &quot;AssetDisplayPageEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AssetDisplayPageEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.asset.display.page.model.impl.AssetDisplayPageEntryImpl"
)
@ProviderType
public interface AssetDisplayPageEntry
	extends AssetDisplayPageEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.asset.display.page.model.impl.AssetDisplayPageEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AssetDisplayPageEntry, Long>
		ASSET_DISPLAY_PAGE_ENTRY_ID_ACCESSOR =
			new Accessor<AssetDisplayPageEntry, Long>() {

				@Override
				public Long get(AssetDisplayPageEntry assetDisplayPageEntry) {
					return assetDisplayPageEntry.getAssetDisplayPageEntryId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AssetDisplayPageEntry> getTypeClass() {
					return AssetDisplayPageEntry.class;
				}

			};

}