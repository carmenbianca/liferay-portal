/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DispatchLog service. Represents a row in the &quot;DispatchLog&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alessio Antonio Rendina
 * @see DispatchLogModel
 * @generated
 */
@ImplementationClassName("com.liferay.dispatch.model.impl.DispatchLogImpl")
@ProviderType
public interface DispatchLog extends DispatchLogModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.dispatch.model.impl.DispatchLogImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DispatchLog, Long> DISPATCH_LOG_ID_ACCESSOR =
		new Accessor<DispatchLog, Long>() {

			@Override
			public Long get(DispatchLog dispatchLog) {
				return dispatchLog.getDispatchLogId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DispatchLog> getTypeClass() {
				return DispatchLog.class;
			}

		};

}