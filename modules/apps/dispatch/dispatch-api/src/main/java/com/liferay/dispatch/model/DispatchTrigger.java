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
 * The extended model interface for the DispatchTrigger service. Represents a row in the &quot;DispatchTrigger&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alessio Antonio Rendina
 * @see DispatchTriggerModel
 * @generated
 */
@ImplementationClassName("com.liferay.dispatch.model.impl.DispatchTriggerImpl")
@ProviderType
public interface DispatchTrigger extends DispatchTriggerModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.dispatch.model.impl.DispatchTriggerImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DispatchTrigger, Long>
		DISPATCH_TRIGGER_ID_ACCESSOR = new Accessor<DispatchTrigger, Long>() {

			@Override
			public Long get(DispatchTrigger dispatchTrigger) {
				return dispatchTrigger.getDispatchTriggerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DispatchTrigger> getTypeClass() {
				return DispatchTrigger.class;
			}

		};

	public com.liferay.portal.kernel.util.UnicodeProperties
		getTypeSettingsProperties();

	public void setTypeSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties
			typeSettingsUnicodeProperties);

}