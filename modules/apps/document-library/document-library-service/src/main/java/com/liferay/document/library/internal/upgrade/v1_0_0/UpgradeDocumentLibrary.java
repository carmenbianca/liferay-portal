/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.upgrade.v1_0_0;

import com.liferay.document.library.kernel.store.Store;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Samuel Ziemer
 * @author Sergio González
 */
public class UpgradeDocumentLibrary extends UpgradeProcess {

	public UpgradeDocumentLibrary(Store store) {
		_store = store;
	}

	@Override
	protected void doUpgrade() throws Exception {
		_deleteChecksumDirectory();

		_deleteTempDirectory();
	}

	private void _deleteChecksumDirectory() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer();
			PreparedStatement ps = connection.prepareStatement(
				"select distinct companyId from DLFileEntry");
			ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				long companyId = rs.getLong("companyId");

				_store.deleteDirectory(companyId, 0, "checksum");
			}
		}
	}

	private void _deleteTempDirectory() {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			_store.deleteDirectory(0, 0, "liferay_temp/");
		}
	}

	private final Store _store;

}