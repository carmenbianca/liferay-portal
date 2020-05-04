/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the RecentLayoutRevision service. Represents a row in the &quot;RecentLayoutRevision&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RecentLayoutRevisionModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.portal.model.impl.RecentLayoutRevisionImpl"
)
@ProviderType
public interface RecentLayoutRevision
	extends PersistedModel, RecentLayoutRevisionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.model.impl.RecentLayoutRevisionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RecentLayoutRevision, Long>
		RECENT_LAYOUT_REVISION_ID_ACCESSOR =
			new Accessor<RecentLayoutRevision, Long>() {

				@Override
				public Long get(RecentLayoutRevision recentLayoutRevision) {
					return recentLayoutRevision.getRecentLayoutRevisionId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<RecentLayoutRevision> getTypeClass() {
					return RecentLayoutRevision.class;
				}

			};

}