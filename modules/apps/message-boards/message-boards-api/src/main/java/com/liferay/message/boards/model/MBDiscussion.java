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
 * The extended model interface for the MBDiscussion service. Represents a row in the &quot;MBDiscussion&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MBDiscussionModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.message.boards.model.impl.MBDiscussionImpl"
)
@ProviderType
public interface MBDiscussion extends MBDiscussionModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.message.boards.model.impl.MBDiscussionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MBDiscussion, Long> DISCUSSION_ID_ACCESSOR =
		new Accessor<MBDiscussion, Long>() {

			@Override
			public Long get(MBDiscussion mbDiscussion) {
				return mbDiscussion.getDiscussionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MBDiscussion> getTypeClass() {
				return MBDiscussion.class;
			}

		};

}