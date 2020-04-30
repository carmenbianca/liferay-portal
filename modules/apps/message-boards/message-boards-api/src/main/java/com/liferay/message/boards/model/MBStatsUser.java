/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the MBStatsUser service. Represents a row in the &quot;MBStatsUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MBStatsUserModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.message.boards.model.impl.MBStatsUserImpl"
)
@ProviderType
public interface MBStatsUser extends MBStatsUserModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.message.boards.model.impl.MBStatsUserImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MBStatsUser, Long> STATS_USER_ID_ACCESSOR =
		new Accessor<MBStatsUser, Long>() {

			@Override
			public Long get(MBStatsUser mbStatsUser) {
				return mbStatsUser.getStatsUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MBStatsUser> getTypeClass() {
				return MBStatsUser.class;
			}

		};

}