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
 * The extended model interface for the EagerBlobEntity service. Represents a row in the &quot;EagerBlobEntity&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EagerBlobEntityModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.portal.tools.service.builder.test.model.impl.EagerBlobEntityImpl"
)
@ProviderType
public interface EagerBlobEntity extends EagerBlobEntityModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.tools.service.builder.test.model.impl.EagerBlobEntityImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EagerBlobEntity, Long>
		EAGER_BLOB_ENTITY_ID_ACCESSOR = new Accessor<EagerBlobEntity, Long>() {

			@Override
			public Long get(EagerBlobEntity eagerBlobEntity) {
				return eagerBlobEntity.getEagerBlobEntityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EagerBlobEntity> getTypeClass() {
				return EagerBlobEntity.class;
			}

		};

}