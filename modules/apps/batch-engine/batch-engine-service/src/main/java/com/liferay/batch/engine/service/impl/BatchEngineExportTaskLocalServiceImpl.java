/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.service.impl;

import com.liferay.batch.engine.model.BatchEngineExportTask;
import com.liferay.batch.engine.service.base.BatchEngineExportTaskLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ivica Cardic
 */
@Component(
	property = "model.class.name=com.liferay.batch.engine.model.BatchEngineExportTask",
	service = AopService.class
)
public class BatchEngineExportTaskLocalServiceImpl
	extends BatchEngineExportTaskLocalServiceBaseImpl {

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public BatchEngineExportTask addBatchEngineExportTask(
		long companyId, long userId, String callbackURL, String className,
		String contentType, String executeStatus, List<String> fieldNamesList,
		Map<String, Serializable> parameters, String taskItemDelegateName) {

		BatchEngineExportTask batchEngineExportTask =
			batchEngineExportTaskPersistence.create(
				counterLocalService.increment(
					BatchEngineExportTask.class.getName()));

		batchEngineExportTask.setCompanyId(companyId);
		batchEngineExportTask.setUserId(userId);
		batchEngineExportTask.setCallbackURL(callbackURL);
		batchEngineExportTask.setClassName(className);
		batchEngineExportTask.setContent(
			new OutputBlob(new UnsyncByteArrayInputStream(new byte[0]), 0));
		batchEngineExportTask.setContentType(contentType);
		batchEngineExportTask.setExecuteStatus(executeStatus);
		batchEngineExportTask.setFieldNamesList(fieldNamesList);
		batchEngineExportTask.setParameters(parameters);
		batchEngineExportTask.setTaskItemDelegateName(taskItemDelegateName);

		return batchEngineExportTaskPersistence.update(batchEngineExportTask);
	}

	@Override
	public List<BatchEngineExportTask> getBatchEngineExportTasks(
		String executeStatus) {

		return batchEngineExportTaskPersistence.findByExecuteStatus(
			executeStatus);
	}

}