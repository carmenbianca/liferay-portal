/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PortletItem service. Represents a row in the &quot;PortletItem&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PortletItemModel
 * @generated
 */
@ImplementationClassName("com.liferay.portal.model.impl.PortletItemImpl")
@ProviderType
public interface PortletItem extends PersistedModel, PortletItemModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.model.impl.PortletItemImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PortletItem, Long> PORTLET_ITEM_ID_ACCESSOR =
		new Accessor<PortletItem, Long>() {

			@Override
			public Long get(PortletItem portletItem) {
				return portletItem.getPortletItemId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PortletItem> getTypeClass() {
				return PortletItem.class;
			}

		};

}