/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.internal.service;

import com.liferay.petra.model.adapter.util.ModelAdapterUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorAdapter;
import com.liferay.trash.kernel.model.TrashEntry;
import com.liferay.trash.kernel.model.TrashEntryList;
import com.liferay.trash.kernel.service.TrashEntryServiceWrapper;
import com.liferay.trash.service.TrashEntryService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class ModularTrashEntryServiceWrapper extends TrashEntryServiceWrapper {

	public ModularTrashEntryServiceWrapper() {
		super(null);
	}

	public ModularTrashEntryServiceWrapper(
		com.liferay.trash.kernel.service.TrashEntryService trashEntryService) {

		super(trashEntryService);
	}

	@Override
	public void deleteEntries(long groupId) throws PortalException {
		_trashEntryService.deleteEntries(groupId);
	}

	@Override
	public void deleteEntries(long[] entryIds) throws PortalException {
		_trashEntryService.deleteEntries(entryIds);
	}

	@Override
	public void deleteEntry(long entryId) throws PortalException {
		_trashEntryService.deleteEntry(entryId);
	}

	@Override
	public void deleteEntry(String className, long classPK)
		throws PortalException {

		_trashEntryService.deleteEntry(className, classPK);
	}

	@Override
	public TrashEntryList getEntries(long groupId) throws PrincipalException {
		return ModelAdapterUtil.adapt(
			TrashEntryList.class, _trashEntryService.getEntries(groupId));
	}

	@Override
	public TrashEntryList getEntries(
			long groupId, int start, int end, OrderByComparator<TrashEntry> obc)
		throws PrincipalException {

		return ModelAdapterUtil.adapt(
			TrashEntryList.class,
			_trashEntryService.getEntries(
				groupId, start, end,
				new TrashEntryOrderByComparatorAdapter(obc)));
	}

	@Override
	public List<TrashEntry> getEntries(long groupId, String className)
		throws PrincipalException {

		return ModelAdapterUtil.adapt(
			TrashEntry.class,
			_trashEntryService.getEntries(groupId, className));
	}

	@Override
	public String getOSGiServiceIdentifier() {
		return _trashEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public void moveEntry(
			String className, long classPK, long destinationContainerModelId,
			ServiceContext serviceContext)
		throws PortalException {

		_trashEntryService.moveEntry(
			className, classPK, destinationContainerModelId, serviceContext);
	}

	@Override
	public TrashEntry restoreEntry(long entryId) throws PortalException {
		return ModelAdapterUtil.adapt(
			TrashEntry.class, _trashEntryService.restoreEntry(entryId));
	}

	@Override
	public TrashEntry restoreEntry(
			long entryId, long overrideClassPK, String name)
		throws PortalException {

		return ModelAdapterUtil.adapt(
			TrashEntry.class,
			_trashEntryService.restoreEntry(entryId, overrideClassPK, name));
	}

	@Override
	public TrashEntry restoreEntry(String className, long classPK)
		throws PortalException {

		return ModelAdapterUtil.adapt(
			TrashEntry.class,
			_trashEntryService.restoreEntry(className, classPK));
	}

	@Override
	public TrashEntry restoreEntry(
			String className, long classPK, long overrideClassPK, String name)
		throws PortalException {

		return ModelAdapterUtil.adapt(
			TrashEntry.class,
			_trashEntryService.restoreEntry(
				className, classPK, overrideClassPK, name));
	}

	@Reference(unbind = "-")
	protected void setTrashEntryService(TrashEntryService trashEntryService) {
		_trashEntryService = trashEntryService;
	}

	private TrashEntryService _trashEntryService;

	private static class TrashEntryOrderByComparatorAdapter
		extends OrderByComparatorAdapter
			<com.liferay.trash.model.TrashEntry, TrashEntry> {

		public TrashEntryOrderByComparatorAdapter(
			OrderByComparator<TrashEntry> orderByComparator) {

			super(orderByComparator);
		}

		@Override
		public TrashEntry adapt(com.liferay.trash.model.TrashEntry trashEntry) {
			return ModelAdapterUtil.adapt(TrashEntry.class, trashEntry);
		}

	}

}