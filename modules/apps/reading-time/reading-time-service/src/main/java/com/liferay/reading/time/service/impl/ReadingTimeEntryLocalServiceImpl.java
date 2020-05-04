/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.reading.time.calculator.ReadingTimeCalculator;
import com.liferay.reading.time.model.ReadingTimeEntry;
import com.liferay.reading.time.service.base.ReadingTimeEntryLocalServiceBaseImpl;

import java.time.Duration;

import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = "model.class.name=com.liferay.reading.time.model.ReadingTimeEntry",
	service = AopService.class
)
public class ReadingTimeEntryLocalServiceImpl
	extends ReadingTimeEntryLocalServiceBaseImpl {

	@Override
	public ReadingTimeEntry addReadingTimeEntry(
		GroupedModel groupedModel, Duration readingTimeDuration) {

		return addReadingTimeEntry(
			groupedModel.getGroupId(),
			_classNameLocalService.getClassNameId(groupedModel.getModelClass()),
			(Long)groupedModel.getPrimaryKeyObj(), readingTimeDuration);
	}

	@Override
	public ReadingTimeEntry addReadingTimeEntry(
		long groupId, long classNameId, long classPK,
		Duration readingTimeDuration) {

		long entryId = counterLocalService.increment();

		ReadingTimeEntry entry = readingTimeEntryPersistence.create(entryId);

		entry.setGroupId(groupId);
		entry.setClassNameId(classNameId);
		entry.setClassPK(classPK);
		entry.setReadingTime(readingTimeDuration.toMillis());

		return readingTimeEntryPersistence.update(entry);
	}

	@Override
	public ReadingTimeEntry deleteReadingTimeEntry(GroupedModel groupedModel) {
		ReadingTimeEntry readingTimeEntry = fetchReadingTimeEntry(groupedModel);

		if (readingTimeEntry != null) {
			return deleteReadingTimeEntry(readingTimeEntry);
		}

		return null;
	}

	@Override
	public ReadingTimeEntry deleteReadingTimeEntry(
		long groupId, long classNameId, long classPK) {

		ReadingTimeEntry readingTimeEntry = fetchReadingTimeEntry(
			groupId, classNameId, classPK);

		if (readingTimeEntry != null) {
			return deleteReadingTimeEntry(readingTimeEntry);
		}

		return null;
	}

	@Override
	public ReadingTimeEntry fetchOrAddReadingTimeEntry(
		GroupedModel groupedModel) {

		ReadingTimeEntry readingTimeEntry = fetchReadingTimeEntry(groupedModel);

		if (readingTimeEntry != null) {
			return readingTimeEntry;
		}

		return updateReadingTimeEntry(groupedModel);
	}

	@Override
	public ReadingTimeEntry fetchReadingTimeEntry(GroupedModel groupedModel) {
		return fetchReadingTimeEntry(
			groupedModel.getGroupId(),
			_classNameLocalService.getClassNameId(groupedModel.getModelClass()),
			(Long)groupedModel.getPrimaryKeyObj());
	}

	@Override
	public ReadingTimeEntry fetchReadingTimeEntry(
		long groupId, long classNameId, long classPK) {

		return readingTimeEntryPersistence.fetchByG_C_C(
			groupId, classNameId, classPK);
	}

	@Override
	public ReadingTimeEntry updateReadingTimeEntry(GroupedModel groupedModel) {
		Optional<Duration> readingTimeOptional =
			_readingTimeCalculator.calculate(groupedModel);

		if (readingTimeOptional.isPresent()) {
			return updateReadingTimeEntry(
				groupedModel.getGroupId(),
				_classNameLocalService.getClassNameId(
					groupedModel.getModelClass()),
				(Long)groupedModel.getPrimaryKeyObj(),
				readingTimeOptional.get());
		}

		return null;
	}

	@Override
	public ReadingTimeEntry updateReadingTimeEntry(
		long groupId, long classNameId, long classPK,
		Duration readingTimeDuration) {

		ReadingTimeEntry readingTimeEntry = fetchReadingTimeEntry(
			groupId, classNameId, classPK);

		if (readingTimeEntry == null) {
			return addReadingTimeEntry(
				groupId, classNameId, classPK, readingTimeDuration);
		}

		readingTimeEntry.setReadingTime(readingTimeDuration.toMillis());

		return updateReadingTimeEntry(readingTimeEntry);
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private ReadingTimeCalculator _readingTimeCalculator;

}