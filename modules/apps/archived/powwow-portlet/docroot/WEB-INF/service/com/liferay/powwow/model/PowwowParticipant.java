/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PowwowParticipant service. Represents a row in the &quot;PowwowParticipant&quot; database table, with each column mapped to a property of this class.
 *
 * @author Shinn Lok
 * @see PowwowParticipantModel
 * @generated
 */
@ImplementationClassName("com.liferay.powwow.model.impl.PowwowParticipantImpl")
@ProviderType
public interface PowwowParticipant
	extends PersistedModel, PowwowParticipantModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.powwow.model.impl.PowwowParticipantImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PowwowParticipant, Long>
		POWWOW_PARTICIPANT_ID_ACCESSOR =
			new Accessor<PowwowParticipant, Long>() {

				@Override
				public Long get(PowwowParticipant powwowParticipant) {
					return powwowParticipant.getPowwowParticipantId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<PowwowParticipant> getTypeClass() {
					return PowwowParticipant.class;
				}

			};

}