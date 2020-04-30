/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LazyBlobEntity service. Represents a row in the &quot;LazyBlobEntity&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LazyBlobEntityModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.portal.tools.service.builder.test.model.impl.LazyBlobEntityImpl"
)
@ProviderType
public interface LazyBlobEntity extends LazyBlobEntityModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.tools.service.builder.test.model.impl.LazyBlobEntityImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LazyBlobEntity, Long>
		LAZY_BLOB_ENTITY_ID_ACCESSOR = new Accessor<LazyBlobEntity, Long>() {

			@Override
			public Long get(LazyBlobEntity lazyBlobEntity) {
				return lazyBlobEntity.getLazyBlobEntityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LazyBlobEntity> getTypeClass() {
				return LazyBlobEntity.class;
			}

		};

}