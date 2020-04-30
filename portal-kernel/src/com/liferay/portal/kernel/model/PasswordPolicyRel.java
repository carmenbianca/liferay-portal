/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PasswordPolicyRel service. Represents a row in the &quot;PasswordPolicyRel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PasswordPolicyRelModel
 * @generated
 */
@ImplementationClassName("com.liferay.portal.model.impl.PasswordPolicyRelImpl")
@ProviderType
public interface PasswordPolicyRel
	extends PasswordPolicyRelModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.model.impl.PasswordPolicyRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PasswordPolicyRel, Long>
		PASSWORD_POLICY_REL_ID_ACCESSOR =
			new Accessor<PasswordPolicyRel, Long>() {

				@Override
				public Long get(PasswordPolicyRel passwordPolicyRel) {
					return passwordPolicyRel.getPasswordPolicyRelId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<PasswordPolicyRel> getTypeClass() {
					return PasswordPolicyRel.class;
				}

			};

}