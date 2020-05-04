/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Folder service. Represents a row in the &quot;Mail_Folder&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FolderModel
 * @generated
 */
@ImplementationClassName("com.liferay.mail.reader.model.impl.FolderImpl")
@ProviderType
public interface Folder extends FolderModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.mail.reader.model.impl.FolderImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Folder, Long> FOLDER_ID_ACCESSOR =
		new Accessor<Folder, Long>() {

			@Override
			public Long get(Folder folder) {
				return folder.getFolderId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Folder> getTypeClass() {
				return Folder.class;
			}

		};

}