/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.exportimport.data.handler;

import java.util.function.Consumer;

/**
 * @author Adolfo Pérez
 */
public interface DLExportableRepositoryPublisher {

	public void publish(long groupId, Consumer<Long> repositoryIdConsumer);

}