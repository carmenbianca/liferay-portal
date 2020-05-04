/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SocialActivitySet service. Represents a row in the &quot;SocialActivitySet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivitySetModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.portlet.social.model.impl.SocialActivitySetImpl"
)
@ProviderType
public interface SocialActivitySet
	extends PersistedModel, SocialActivitySetModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portlet.social.model.impl.SocialActivitySetImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SocialActivitySet, Long>
		ACTIVITY_SET_ID_ACCESSOR = new Accessor<SocialActivitySet, Long>() {

			@Override
			public Long get(SocialActivitySet socialActivitySet) {
				return socialActivitySet.getActivitySetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SocialActivitySet> getTypeClass() {
				return SocialActivitySet.class;
			}

		};

}