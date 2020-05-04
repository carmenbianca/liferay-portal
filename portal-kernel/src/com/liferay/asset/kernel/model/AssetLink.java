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
 * The extended model interface for the AssetLink service. Represents a row in the &quot;AssetLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AssetLinkModel
 * @generated
 */
@ImplementationClassName("com.liferay.portlet.asset.model.impl.AssetLinkImpl")
@ProviderType
public interface AssetLink extends AssetLinkModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portlet.asset.model.impl.AssetLinkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AssetLink, Long> LINK_ID_ACCESSOR =
		new Accessor<AssetLink, Long>() {

			@Override
			public Long get(AssetLink assetLink) {
				return assetLink.getLinkId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AssetLink> getTypeClass() {
				return AssetLink.class;
			}

		};
	public static final Accessor<AssetLink, Long> ENTRY_ID2_ACCESSOR =
		new Accessor<AssetLink, Long>() {

			@Override
			public Long get(AssetLink assetLink) {
				return assetLink.getEntryId2();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AssetLink> getTypeClass() {
				return AssetLink.class;
			}

		};

}